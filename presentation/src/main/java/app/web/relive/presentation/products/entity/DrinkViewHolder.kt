package app.web.relive.presentation.products.entity

import androidx.recyclerview.widget.RecyclerView
import app.web.relive.presentation.databinding.ItemProductBinding
import app.web.relive.presentation.extension.load

class DrinkViewHolder(val itemBinding: ItemProductBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(drink: DrinkUI) = with(itemView) {
        itemBinding.itemProductContainer.transitionName = drink.idDrink.toString()
        itemBinding.itemProductIdTxv.text = drink.idDrink.toString()
        itemBinding.itemProductImv.load(drink.strDrinkThumb)
        itemBinding.itemProductNameTxv.text = drink.strDrink
    }

}