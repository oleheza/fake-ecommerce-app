package ua.oldev.fakeecommerceapp.core.data.network.client

import ua.oldev.fakeecommerceapp.core.data.network.dto.ProductDTO

interface ApiClient {
    suspend fun getAllCategories(): List<String>
    suspend fun getAllProductsInCategory(category: String): List<ProductDTO>
    suspend fun getProductById(id: Int): ProductDTO?
}