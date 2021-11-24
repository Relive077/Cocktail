package app.web.relive.presentation.products.productlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import app.web.relive.domain.products.usecase.GetBeersListByCoroutineParams
import app.web.relive.domain.products.usecase.GetBeersListByCoroutineUseCase
import app.web.relive.presentation.base.adapter.RecyclerItem
import app.web.relive.presentation.base.viewmodel.BaseViewModel
import app.web.relive.presentation.products.entity.DrinkMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val getBeersListByCoroutineUseCase: GetBeersListByCoroutineUseCase,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _productsListByCoroutine =
        MutableStateFlow<PagingData<RecyclerItem>>(PagingData.empty())
    val productsListByCoroutine: Flow<PagingData<RecyclerItem>> = _productsListByCoroutine


    init {
        getProductsBaseOnPath("")
    }

    private fun getProductsByCoroutinePath(ids: String) =
        getBeersListByCoroutineUseCase(GetBeersListByCoroutineParams(ids = ids))
            .cachedIn(viewModelScope)

    private fun getProductsBaseOnPath(ids: String) {
        viewModelScope.launch {
            _productsListByCoroutine.value = getProductsByCoroutinePath(ids).first()
                .map { drink ->
                    DrinkMapper().mapLeftToRight(drink)
                }
        }
    }

}