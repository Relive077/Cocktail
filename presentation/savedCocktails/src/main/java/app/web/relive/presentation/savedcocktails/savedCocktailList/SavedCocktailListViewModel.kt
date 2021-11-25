package app.web.relive.presentation.savedcocktails.savedCocktailList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import app.web.relive.presentation.alcoholiccocktails.base.viewmodel.BaseViewModel
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDb
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedCocktailListViewModel @Inject constructor(
    private val alcoholicCocktailDao: AlcoholicCocktailDao,
    private val nonAlcoholicCocktailDao: NonAlcoholicCocktailDao,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _savedAlcoholDrinks =
        MutableLiveData<List<AlcoholicCocktailDb>>()
    val savedAlcoholDrinks: LiveData<List<AlcoholicCocktailDb>> = _savedAlcoholDrinks

    private val _savedNonAlcoholDrinks =
        MutableLiveData<List<NonAlcoholicCocktailDb>>()
    val savedNonAlcoholDrinks: LiveData<List<NonAlcoholicCocktailDb>> = _savedNonAlcoholDrinks

    init {
        getSavedAlcoholDrinks()
        getSavedNonAlcoholDrinks()
    }

    private fun getSavedAlcoholDrinks() {
        viewModelScope.launch {
            _savedAlcoholDrinks.value = alcoholicCocktailDao.getAllAlcoholicDrinks()
        }
    }

    private fun getSavedNonAlcoholDrinks() {
        viewModelScope.launch {
            _savedNonAlcoholDrinks.value = nonAlcoholicCocktailDao.getAllNonAlcoholicDrinks()
        }
    }


}