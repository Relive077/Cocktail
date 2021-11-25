package app.web.relive.domain.products.usecase

import androidx.paging.PagingData
import app.web.relive.domain.base.usecase.GeneralUseCase
import app.web.relive.domain.products.entity.Drink
import app.web.relive.domain.products.repository.DrinkListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNonAlcoholicDrinkUseCase @Inject constructor(
    private val drinkListRepository: DrinkListRepository,
) : GeneralUseCase<Flow<PagingData<Drink>>, GetNonAlcoholicDrinkParams> {

    override fun invoke(params: GetNonAlcoholicDrinkParams): Flow<PagingData<Drink>> =
        drinkListRepository.fetchNonAlcoholicDrinks()

}

@JvmInline
value class GetNonAlcoholicDrinkParams(val ids: String)