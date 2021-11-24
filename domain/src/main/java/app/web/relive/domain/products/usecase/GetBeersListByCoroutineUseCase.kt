package app.web.relive.domain.products.usecase

import androidx.paging.PagingData
import app.web.relive.domain.base.usecase.GeneralUseCase
import app.web.relive.domain.products.entity.Drink
import app.web.relive.domain.products.repository.ProductsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBeersListByCoroutineUseCase @Inject constructor(
    private val productsListRepository: ProductsListRepository,
) : GeneralUseCase<Flow<PagingData<Drink>>, GetBeersListByCoroutineParams> {

    override fun invoke(params: GetBeersListByCoroutineParams): Flow<PagingData<Drink>> =
        productsListRepository.fetchDrinks()

}

@JvmInline
value class GetBeersListByCoroutineParams(val ids: String)