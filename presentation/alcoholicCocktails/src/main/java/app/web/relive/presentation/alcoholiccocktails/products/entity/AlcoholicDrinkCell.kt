package app.web.relive.presentation.alcoholiccocktails.products.entity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import app.web.relive.presentation.alcoholiccocktails.R
import app.web.relive.presentation.alcoholiccocktails.base.adapter.Cell
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.databinding.ItemProductBinding

object AlcoholicDrinkCell : Cell<RecyclerItem, ViewBinding> {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is AlcoholicDrinkUI
    }

    override fun type(): Int {
        return R.layout.item_product
    }

    override fun binding(parent: ViewGroup): ItemProductBinding {
        return ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return AlcoholicDrinkViewHolder(binding(parent))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClick: ((RecyclerItem, View) -> Unit)?
    ) {
        if (holder is AlcoholicDrinkViewHolder && item is AlcoholicDrinkUI) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClick?.run {
                    this(item, holder.itemBinding.itemProductContainer)
                }
            }
        }
    }

}