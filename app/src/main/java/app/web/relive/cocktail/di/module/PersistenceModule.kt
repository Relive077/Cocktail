package app.web.relive.cocktail.di.module

import android.app.Application
import androidx.room.Room
import app.web.relive.data.products.local.DrinkDao
import app.web.relive.data.products.local.DrinkDatabase
import app.web.relive.data.products.remote.ProductsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDrinkDatabase(
        application: Application
    ): DrinkDatabase {
        return Room
            .databaseBuilder(application, DrinkDatabase::class.java, "Drink.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDrinkDao(drinkDatabase: DrinkDatabase): DrinkDao {
        return drinkDatabase.drinkDao()
    }

}