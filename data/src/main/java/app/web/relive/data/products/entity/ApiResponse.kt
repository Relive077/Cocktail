package app.web.relive.data.products.entity


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("drinks") val drinks: List<DrinkResponse>
)