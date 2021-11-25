package app.web.relive.presentation.alcoholiccocktails.products.entity

import androidx.recyclerview.widget.RecyclerView
import app.web.relive.presentation.alcoholiccocktails.databinding.ItemProductBinding
import app.web.relive.presentation.alcoholiccocktails.extension.load

class AlcoholicDrinkViewHolder(val itemBinding: ItemProductBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(drink: AlcoholicDrinkUI) = with(itemView) {
        itemBinding.itemProductContainer.transitionName = drink.id.toString()
        itemBinding.itemProductIdTxv.text = drink.id.toString()
        itemBinding.itemProductImv.load(drink.imageUrl)
        itemBinding.itemProductNameTxv.text = drink.name
    }

}