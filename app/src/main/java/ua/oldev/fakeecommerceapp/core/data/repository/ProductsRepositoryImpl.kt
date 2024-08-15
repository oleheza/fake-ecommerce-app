package ua.oldev.fakeecommerceapp.core.data.repository

import timber.log.Timber
import ua.oldev.fakeecommerceapp.core.data.network.dto.ProductDTO
import ua.oldev.fakeecommerceapp.core.data.network.service.ProductsService
import ua.oldev.fakeecommerceapp.core.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsService: ProductsService
) : ProductsRepository {
    override suspend fun getAllInCategory(category: String): Result<List<ProductDTO>> {
        return try {
            val products = productsService.getAllInCategory(category)
            Result.success(products)
        } catch (e: Exception) {
            Timber.e(e, "Failed to load products in category")
            Result.failure(e)
        }
    }

    override suspend fun getById(productId: Int): Result<ProductDTO?> {
        return try {
            val product = productsService.getById(productId)
            Result.success(product)
        } catch (e: Exception) {
            Timber.e(e, "Failed to load product by id")
            Result.failure(e)
        }
    }
}