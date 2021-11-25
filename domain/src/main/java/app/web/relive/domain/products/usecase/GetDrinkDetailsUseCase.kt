package app.web.relive.domain.products.usecase

import androidx.paging.PagingData
import app.web.relive.domain.base.usecase.GeneralSuspendUseCase
import app.web.relive.domain.base.usecase.GeneralUseCase
import app.web.relive.domain.products.entity.Drink
import app.web.relive.domain.products.entity.DrinkDetails
import app.web.relive.domain.products.repository.DrinkListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDrinkDetailsUseCase @Inject constructor(
    private val drinkListRepository: DrinkListRepository,
) : GeneralSuspendUseCase<DrinkDetails, GetDrinkParams> {

    override suspend fun invoke(params: GetDrinkParams): DrinkDetails =
        drinkListRepository.fetchDrinkDetails(params.ids)

}

@JvmInline
value class GetDrinkParams(val ids: String)