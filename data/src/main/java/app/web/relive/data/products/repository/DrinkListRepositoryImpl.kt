package app.web.relive.data.products.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.web.relive.data.products.datasource.AlcoholicPagingSource
import app.web.relive.data.products.datasource.NonAlcoholicPagingSource
import app.web.relive.domain.extension.allowReads
import app.web.relive.domain.products.entity.Drink
import app.web.relive.domain.products.repository.DrinkListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkListRepositoryImpl @Inject constructor(
    private val alcoholicPagingSource: AlcoholicPagingSource,
    private val nonAlcoholicPagingSource: NonAlcoholicPagingSource
) : DrinkListRepository {



    override fun fetchAlcoholicDrinks(): Flow<PagingData<Drink>> =
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
                pagingSourceFactory = { alcoholicPagingSource }
            ).flow
        }

    override fun fetchNonAlcoholicDrinks(): Flow<PagingData<Drink>> =
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
                pagingSourceFactory = { nonAlcoholicPagingSource }
            ).flow
        }

}