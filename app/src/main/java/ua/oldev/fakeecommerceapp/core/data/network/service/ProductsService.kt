package ua.oldev.fakeecommerceapp.core.data.network.service

import retrofit2.http.GET
import retrofit2.http.Path
import ua.oldev.fakeecommerceapp.core.data.network.dto.ProductDTO

interface ProductsService {

    @GET("/products/category/{category}")
    suspend fun getAllInCategory(@Path("category") category: String): List<ProductDTO>

    @GET("/products/{product_id}")
    suspend fun getById(@Path("product_id") productId: Int): ProductDTO
}