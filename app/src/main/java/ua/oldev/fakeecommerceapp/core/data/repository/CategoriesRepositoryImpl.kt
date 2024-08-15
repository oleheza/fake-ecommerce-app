package ua.oldev.fakeecommerceapp.core.data.repository

import timber.log.Timber
import ua.oldev.fakeecommerceapp.core.data.network.service.CategoriesService
import ua.oldev.fakeecommerceapp.core.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesService: CategoriesService
) : CategoriesRepository {
    override suspend fun getCategories(): Result<List<String>> {
        return try {
            val categories = categoriesService.getCategories()
            Result.success(categories)
        } catch (e: Exception) {
            Timber.e(e, "Failed to load categories list")
            Result.failure(e)
        }
    }
}