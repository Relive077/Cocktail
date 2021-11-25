package app.web.relive.data.products.entity


import com.google.gson.annotations.SerializedName

data class ApiDrinkDetailResponse(
    @SerializedName("drinks") val drinks: List<DrinkDetailsResponse>
)