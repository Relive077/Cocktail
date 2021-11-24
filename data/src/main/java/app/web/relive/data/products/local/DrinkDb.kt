package app.web.relive.data.products.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
data class DrinkDb(
    @PrimaryKey val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
)
