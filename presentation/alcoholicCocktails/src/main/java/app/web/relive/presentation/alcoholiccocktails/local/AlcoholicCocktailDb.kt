package app.web.relive.presentation.alcoholiccocktails.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AlcoholicCocktailDb(
  @PrimaryKey val idDrink: String,
  val strDrink: String,
  val strDrinkThumb: String?
)
