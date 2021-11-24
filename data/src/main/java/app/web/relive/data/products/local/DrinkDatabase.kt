package app.web.relive.data.products.local

import androidx.room.Database
import androidx.room.RoomDatabase
import app.web.relive.domain.products.entity.Drink

@Database(entities = [DrinkDb::class], version = 1, exportSchema = false)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
}