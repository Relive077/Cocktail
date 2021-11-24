package app.web.relive.data.products.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DrinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkList(drinkList: List<DrinkDb>)

    @Query("SELECT * FROM DrinkDb")
    suspend fun getDrinkList(): List<DrinkDb>
}