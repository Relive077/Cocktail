package app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktaildetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import app.web.relive.domain.products.entity.DrinkDetails
import app.web.relive.domain.products.usecase.GetAlcoholicDrinkParams
import app.web.relive.domain.products.usecase.GetAlcoholicDrinkUseCase
import app.web.relive.domain.products.usecase.GetDrinkDetailsUseCase
import app.web.relive.domain.products.usecase.GetDrinkParams
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.base.viewmodel.BaseViewModel
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicDrinkUIToAlcoholicCocktailDbMapper
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkMapper
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlcoholicCocktailDetailViewModel @Inject constructor(
    private val getDrinkDetailsUseCase: GetDrinkDetailsUseCase,
    private val alcoholicCocktailDao: AlcoholicCocktailDao,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    val _drinkDetails = MutableLiveData<DrinkDetails>()
    val drinkDetails: LiveData<DrinkDetails> = _drinkDetails

    fun getAlcoholicDrinkDetails(idDrink: String) {
        viewModelScope.launch {
            _drinkDetails.value = getDrinkDetailsUseCase.invoke(GetDrinkParams(idDrink))
        }
    }

    fun saveAlcoholicDrink(alcoholicDrinkUI: AlcoholicDrinkUI) {
        viewModelScope.launch {
            alcoholicCocktailDao.insertAlcoholicDrinkList(
                AlcoholicDrinkUIToAlcoholicCocktailDbMapper().mapLeftToRight(alcoholicDrinkUI)
            )
        }
    }

}