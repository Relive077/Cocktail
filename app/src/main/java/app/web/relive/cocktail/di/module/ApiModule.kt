package app.web.relive.cocktail.di.module

import app.web.relive.data.products.remote.DrinkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    @Singleton
    fun products(retrofit: Retrofit): DrinkApi =
        retrofit.create(DrinkApi::class.java)

}