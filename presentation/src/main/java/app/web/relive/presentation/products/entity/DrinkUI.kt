package app.web.relive.presentation.products.entity

import android.os.Parcelable
import app.web.relive.presentation.base.adapter.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrinkUI(
    override val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String,
) : RecyclerItem, Parcelable