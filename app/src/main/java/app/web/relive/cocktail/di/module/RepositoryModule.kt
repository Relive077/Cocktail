package app.web.relive.cocktail.di.module

import app.web.relive.data.products.datasource.ProductsPagingSource
import app.web.relive.data.products.datasource.ProductsPagingSourceByCoroutine
import app.web.relive.data.products.repository.ProductsListRepositoryImpl
import app.web.relive.domain.products.repository.ProductsListRepository
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
    fun productsList(
        pagingSource: ProductsPagingSource,
        pagingSourceByCoroutine: ProductsPagingSourceByCoroutine
    ): ProductsListRepository =
        ProductsListRepositoryImpl(pagingSource, pagingSourceByCoroutine)

}