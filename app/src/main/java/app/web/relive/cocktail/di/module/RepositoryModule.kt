package app.web.relive.cocktail.di.module

import app.web.relive.data.products.datasource.AlcoholicPagingSource
import app.web.relive.data.products.datasource.NonAlcoholicPagingSource
import app.web.relive.data.products.remote.DrinkApi
import app.web.relive.data.products.repository.DrinkListRepositoryImpl
import app.web.relive.domain.products.repository.DrinkListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun productsDbList(
        alcoholicPagingSource: AlcoholicPagingSource,
        nonAlcoholicPagingSource: NonAlcoholicPagingSource,
        drinkApi: DrinkApi
    ): DrinkListRepository =
        DrinkListRepositoryImpl(alcoholicPagingSource,nonAlcoholicPagingSource,drinkApi)

}