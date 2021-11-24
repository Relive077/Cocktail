package app.web.relive.data.products.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.web.relive.data.products.datasource.ProductsDbPagingSourceByCoroutine
import app.web.relive.data.products.datasource.ProductsPagingSourceByCoroutine
import app.web.relive.domain.extension.allowReads
import app.web.relive.domain.products.entity.Drink
import app.web.relive.domain.products.repository.ProductsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsListRepositoryImpl @Inject constructor(
    private val pagingDbSourceByCoroutine: ProductsDbPagingSourceByCoroutine
) : ProductsListRepository {



    override fun fetchDrinks(): Flow<PagingData<Drink>> =
        allowReads {
            Pager(
                config = PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = false,
                    maxSize = 30,
                    prefetchDistance = 5,
                    initialLoadSize = 10,
                    jumpThreshold = 60
                ),
                pagingSourceFactory = { pagingDbSourceByCoroutine }
            ).flow
        }

}