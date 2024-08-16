package ua.oldev.fakeecommerceapp.products.domain.repository

import ua.oldev.fakeecommerceapp.core.data.network.dto.ProductDTO

interface ProductsRepository {
    suspend fun getAllInCategory(category: String): Result<List<ProductDTO>>

    suspend fun getById(productId: Int): Result<ProductDTO?>
}