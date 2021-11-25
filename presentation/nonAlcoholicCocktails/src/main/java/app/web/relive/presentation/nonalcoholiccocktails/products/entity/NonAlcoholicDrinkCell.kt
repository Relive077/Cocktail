package app.web.relive.presentation.nonalcoholiccocktails.products.entity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import app.web.relive.presentation.nonalcoholiccocktails.R
import app.web.relive.presentation.alcoholiccocktails.base.adapter.Cell
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.databinding.ItemProductBinding

object NonAlcoholicDrinkCell : Cell<RecyclerItem, ViewBinding> {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is NonAlcoholicDrinkUI
    }

    override fun type(): Int {
        return R.layout.item_product
    }

    override fun binding(parent: ViewGroup): ItemProductBinding {
        return ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NonAlcoholicDrinkViewHolder(binding(parent))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClick: ((RecyclerItem, View) -> Unit)?
    ) {
        if (holder is NonAlcoholicDrinkViewHolder && item is NonAlcoholicDrinkUI) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClick?.run {
                    this(item, holder.itemBinding.itemProductContainer)
                }
            }
        }
    }

}