package app.web.relive.data.network

data class ErrorBody(
    val statusCode: Int,
    val error: String,
    val message: String,
)