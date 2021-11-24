package app.web.relive.presentation.products.productlist

import android.view.View
import app.web.relive.presentation.base.adapter.BasePagedListAdapter
import app.web.relive.presentation.base.adapter.RecyclerItem
import app.web.relive.presentation.products.entity.BeerCell

class ProductsListAdapter(onItemClick: (RecyclerItem, View) -> Unit) : BasePagedListAdapter(
    BeerCell,
    onItemClick = onItemClick
)