package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicList

import android.view.View
import app.web.relive.presentation.alcoholiccocktails.base.adapter.BasePagedListAdapter
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.nonalcoholiccocktails.products.entity.NonAlcoholicDrinkCell

class NonAlcoholicCocktailListAdapter(onItemClick: (RecyclerItem, View) -> Unit) : BasePagedListAdapter(
    NonAlcoholicDrinkCell,
    onItemClick = onItemClick
)