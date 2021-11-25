package app.web.relive.presentation.nonalcoholiccocktails.products.entity

import android.os.Parcelable
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class NonAlcoholicDrinkUI(
    override val id: String,
    val name: String,
    val imageUrl: String?,
) : RecyclerItem, Parcelable