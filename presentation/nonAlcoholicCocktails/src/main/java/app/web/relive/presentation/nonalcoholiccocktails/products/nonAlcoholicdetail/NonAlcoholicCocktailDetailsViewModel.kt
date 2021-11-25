package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import app.web.relive.domain.products.entity.DrinkDetails
import app.web.relive.domain.products.usecase.GetDrinkDetailsUseCase
import app.web.relive.domain.products.usecase.GetDrinkParams
import app.web.relive.domain.products.usecase.GetNonAlcoholicDrinkParams
import app.web.relive.domain.products.usecase.GetNonAlcoholicDrinkUseCase
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.base.viewmodel.BaseViewModel
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicDrinkUIToAlcoholicCocktailDbMapper
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkUI
import app.web.relive.presentation.nonalcoholiccocktails.products.entity.NonAlcoholicDrinkMapper
import app.web.relive.presentation.nonalcoholiccocktails.products.entity.NonAlcoholicDrinkUI
import app.web.relive.presentation.nonalcoholiccocktails.products.local.NonAlcoholicDrinkUIToNonAlcoholicCocktailDbMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicCocktailDetailsViewModel @Inject constructor(
    private val nonAlcoholicCocktailDao: NonAlcoholicCocktailDao,
    private val getDrinkDetailsUseCase: GetDrinkDetailsUseCase,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    val _drinkDetails = MutableLiveData<DrinkDetails>()
    val drinkDetails: LiveData<DrinkDetails> = _drinkDetails

    fun getNonAlcoholicDrinkDetails(idDrink: String) {
        viewModelScope.launch {
            _drinkDetails.value = getDrinkDetailsUseCase.invoke(GetDrinkParams(idDrink))
        }
    }

    fun saveNonAlcoholicDrink(nonAlcoholicDrinkUI: NonAlcoholicDrinkUI) {
        viewModelScope.launch {
            nonAlcoholicCocktailDao.insertNonAlcoholicDrinkList(
                NonAlcoholicDrinkUIToNonAlcoholicCocktailDbMapper().mapLeftToRight(nonAlcoholicDrinkUI)
            )
        }
    }


}