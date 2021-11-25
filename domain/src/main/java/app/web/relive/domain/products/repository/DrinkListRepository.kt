package app.web.relive.domain.products.repository

import androidx.paging.PagingData
import app.web.relive.domain.products.entity.Drink
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface DrinkListRepository {

    fun fetchAlcoholicDrinks(): Flow<PagingData<Drink>>

    fun fetchNonAlcoholicDrinks(): Flow<PagingData<Drink>>

}