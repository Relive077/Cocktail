package app.web.relive.data.products.entity


import com.google.gson.annotations.SerializedName

data class DrinkResponse(
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String,
    @SerializedName("idDrink") val idDrink: String
)