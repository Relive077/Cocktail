package app.web.relive.presentation.nonalcoholiccocktails.products.local

import androidx.room.Database
import androidx.room.RoomDatabase
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDb
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDb

@Database(entities = [AlcoholicCocktailDb::class,
    NonAlcoholicCocktailDb::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun alcoholicCocktailDao(): AlcoholicCocktailDao

    abstract fun nonAlcoholicCocktailDao(): NonAlcoholicCocktailDao
}