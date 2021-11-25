package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import app.web.relive.domain.products.usecase.GetNonAlcoholicDrinkParams
import app.web.relive.domain.products.usecase.GetNonAlcoholicDrinkUseCase
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.base.viewmodel.BaseViewModel
import app.web.relive.presentation.nonalcoholiccocktails.products.entity.NonAlcoholicDrinkMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicCocktailListViewModel @Inject constructor(
    private val getNonAlcoholicDrinkUseCase: GetNonAlcoholicDrinkUseCase,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _productsListByCoroutine =
        MutableStateFlow<PagingData<RecyclerItem>>(PagingData.empty())
    val productsListByCoroutine: Flow<PagingData<RecyclerItem>> = _productsListByCoroutine


    init {
        getProductsBaseOnPath("")
    }

    private fun getProductsByCoroutinePath(ids: String) =
        getNonAlcoholicDrinkUseCase(GetNonAlcoholicDrinkParams(ids = ids))
            .cachedIn(viewModelScope)

    private fun getProductsBaseOnPath(ids: String) {
        viewModelScope.launch {
            _productsListByCoroutine.value = getProductsByCoroutinePath(ids).first()
                .map { drink ->
                    NonAlcoholicDrinkMapper().mapLeftToRight(drink)
                }
        }
    }

}