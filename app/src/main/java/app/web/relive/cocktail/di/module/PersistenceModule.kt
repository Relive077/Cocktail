package app.web.relive.cocktail.di.module

import android.app.Application
import androidx.room.Room
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDao
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDao
import app.web.relive.presentation.nonalcoholiccocktails.products.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "Drink.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAlcoholicCocktailDao(appDatabase: AppDatabase): AlcoholicCocktailDao {
        return appDatabase.alcoholicCocktailDao()
    }

    @Provides
    @Singleton
    fun provideNonAlcoholicCocktailDao(appDatabase: AppDatabase): NonAlcoholicCocktailDao {
        return appDatabase.nonAlcoholicCocktailDao()
    }

}