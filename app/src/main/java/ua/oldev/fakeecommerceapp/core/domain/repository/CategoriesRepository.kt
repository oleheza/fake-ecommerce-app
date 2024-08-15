package ua.oldev.fakeecommerceapp.core.domain.repository

interface CategoriesRepository {
    suspend fun getCategories(): Result<List<String>>
}