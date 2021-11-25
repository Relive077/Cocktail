package app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktailList

import android.view.View
import app.web.relive.presentation.alcoholiccocktails.base.adapter.BasePagedListAdapter
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkCell

class AlcoholicCocktailListAdapter(onItemClick: (RecyclerItem, View) -> Unit) : BasePagedListAdapter(
    AlcoholicDrinkCell,
    onItemClick = onItemClick
)