package ua.oldev.fakeecommerceapp.products.domain.model

data class ProductModel(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val rate: Float,
    val ratingCount: Int,
    val price: Float
) {
    fun calculateRating() = rate.div(5)
}
