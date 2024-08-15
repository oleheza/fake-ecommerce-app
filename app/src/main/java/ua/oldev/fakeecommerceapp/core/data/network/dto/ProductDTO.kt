package ua.oldev.fakeecommerceapp.core.data.network.dto

data class ProductDTO(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDTO
)
