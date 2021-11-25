package app.web.relive.data.products.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.web.relive.data.products.entity.DrinkMapper
import app.web.relive.data.products.remote.DrinkApi
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
class AlcoholicPagingSource @Inject constructor(
    private val drinkApi: DrinkApi,
    //private val query: String
) : PagingSource<Int, Drink>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Drink> {
        val position = params.key ?: STARTING_PAGE_INDEX
        //val apiQuery = query

        return try {
            val response = drinkApi.fetchDrinks("Alcoholic").drinks
                .map { DrinkMapper().mapLeftToRight(it)
            }
            
            toLoadResult(response, position)
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