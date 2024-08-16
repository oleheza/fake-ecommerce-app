package ua.oldev.fakeecommerceapp.categories.data.repository

import timber.log.Timber
import ua.oldev.fakeecommerceapp.categories.domain.repository.CategoriesRepository
import ua.oldev.fakeecommerceapp.core.data.network.client.ApiClient
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : CategoriesRepository {
    override suspend fun getCategories(): Result<List<String>> {
        return try {
            val categories = apiClient.getAllCategories()
            Result.success(categories)
        } catch (e: Exception) {
            Timber.e(e, "Failed to load categories list")
            Result.failure(e)
        }
    }
}