package ua.oldev.fakeecommerceapp.core.data.network.service

import retrofit2.http.GET

interface CategoriesService {

    @GET("/products/categories")
    suspend fun getCategories(): List<String>

}