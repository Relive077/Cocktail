package app.web.relive.presentation.alcoholiccocktails.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlcoholicCocktailDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAlcoholicDrinkList(alcoholicCocktail: AlcoholicCocktailDb)

  @Query("SELECT * FROM AlcoholicCocktailDb")
  suspend fun getAllAlcoholicDrinks(): List<AlcoholicCocktailDb>
}
