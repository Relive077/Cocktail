package app.web.relive.data.products.remote

import app.web.relive.data.network.BaseApiService
import app.web.relive.data.network.GenericNetworkResponse
import app.web.relive.data.products.entity.ApiDrinkDetailResponse
import app.web.relive.data.products.entity.ApiResponse
import app.web.relive.data.products.entity.DrinkResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi : BaseApiService {

    @GET("/api/json/v1/1/filter.php")
    suspend fun fetchDrinks(
        @Query("a") drinkType: String
    ): ApiResponse

    @GET("/api/json/v1/1/lookup.php")
    suspend fun fetchDrinkDetails(
        @Query("i") idDrink: String
    ): ApiDrinkDetailResponse

}