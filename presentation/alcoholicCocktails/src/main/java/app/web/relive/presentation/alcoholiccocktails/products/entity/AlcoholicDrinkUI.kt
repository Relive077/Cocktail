package app.web.relive.presentation.alcoholiccocktails.products.entity

import android.os.Parcelable
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlcoholicDrinkUI(
    override val id: String,
    val name: String,
    val imageUrl: String?,
) : RecyclerItem, Parcelable