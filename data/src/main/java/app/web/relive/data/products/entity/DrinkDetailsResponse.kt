package app.web.relive.data.products.entity

import com.google.gson.annotations.SerializedName

data class DrinkDetailsResponse(
    @SerializedName("strInstructions") val strInstructions: String?,
    @SerializedName("strTags") val strTags: String?,
)