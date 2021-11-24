package app.web.relive.data.products.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.web.relive.data.products.entity.DrinkMapper
import app.web.relive.data.products.local.DrinkDao
import app.web.relive.data.products.local.DrinkDbToDrinkMapper
import app.web.relive.data.products.local.DrinkResponseToDrinkDbMapper
import app.web.relive.data.products.remote.ProductsApi
import app.web.relive.domain.base.Failure
import app.web.relive.domain.products.entity.Drink
import io.reactivex.rxjava3.annotations.NonNull
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject
import javax.inject.Singleton


private const val STARTING_PAGE_INDEX = 1

@Singleton
class ProductsDbPagingSourceByCoroutine @Inject constructor(
    private val productsApi: ProductsApi,
    private val drinkDao: DrinkDao
    //private val query: String
) : PagingSource<Int, Drink>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Drink> {
        val position = params.key ?: STARTING_PAGE_INDEX
        //val apiQuery = query

        return try {
            val response = productsApi.fetchDrinks("Alcoholic").drinks

            drinkDao.insertDrinkList(response.map {
                DrinkResponseToDrinkDbMapper().mapLeftToRight(it)
            })

            val dbResponse = drinkDao.getDrinkList().map {
                DrinkDbToDrinkMapper().mapLeftToRight(it)
            }
            
            toLoadResult(dbResponse, position)
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException, is SocketTimeoutException -> {
                    LoadResult.Error(
                        Failure.NoInternet(e.message)
                    )
                }
                is TimeoutException -> {
                    LoadResult.Error(
                        Failure.Timeout(e.message)
                    )
                }
                else -> {
                    LoadResult.Error(
                        Failure.Unknown(e.message)
                    )
                }
            }
        }
    }

    override val jumpingSupported = true

    override fun getRefreshKey(state: PagingState<Int, Drink>): Int? = state.anchorPosition

    private fun toLoadResult(
        @NonNull response: List<Drink>,
        position: Int,
    ): LoadResult<Int, Drink> {
        return LoadResult.Page(
            data = response,
            prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
            nextKey = if (response.isEmpty()) null else position + 1,
            itemsBefore = LoadResult.Page.COUNT_UNDEFINED,
            itemsAfter = LoadResult.Page.COUNT_UNDEFINED
        )
    }

}