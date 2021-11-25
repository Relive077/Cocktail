package app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktailList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import app.web.relive.domain.products.usecase.GetAlcoholicDrinkParams
import app.web.relive.domain.products.usecase.GetAlcoholicDrinkUseCase
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
class AlcoholicCocktailListViewModel @Inject constructor(
    private val getAlcoholicDrinkUseCase: GetAlcoholicDrinkUseCase,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _productsListByCoroutine =
        MutableStateFlow<PagingData<RecyclerItem>>(PagingData.empty())
    val productsListByCoroutine: Flow<PagingData<RecyclerItem>> = _productsListByCoroutine


    init {
        getProductsBaseOnPath("")
    }

    private fun getProductsByCoroutinePath(ids: String) =
        getAlcoholicDrinkUseCase(GetAlcoholicDrinkParams(ids = ids))
            .cachedIn(viewModelScope)

    private fun getProductsBaseOnPath(ids: String) {
        viewModelScope.launch {
            _productsListByCoroutine.value = getProductsByCoroutinePath(ids).first()
                .map { drink ->
                    AlcoholicDrinkMapper().mapLeftToRight(drink)
                }
        }
    }

}