package app.web.relive.presentation.alcoholiccocktails.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NonAlcoholicCocktailDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertNonAlcoholicDrinkList(nonAlcoholicCocktail: NonAlcoholicCocktailDb)

  @Query("SELECT * FROM NonAlcoholicCocktailDb")
  suspend fun getAllNonAlcoholicDrinks(): List<NonAlcoholicCocktailDb>
}
