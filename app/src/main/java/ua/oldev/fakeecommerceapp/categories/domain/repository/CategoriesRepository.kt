package ua.oldev.fakeecommerceapp.categories.domain.repository

interface CategoriesRepository {
    suspend fun getCategories(): Result<List<String>>
}