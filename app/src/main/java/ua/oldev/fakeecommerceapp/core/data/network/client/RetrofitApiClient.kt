package ua.oldev.fakeecommerceapp.core.data.network.client

import ua.oldev.fakeecommerceapp.core.data.network.dto.ProductDTO
import ua.oldev.fakeecommerceapp.core.data.network.service.CategoriesService
import ua.oldev.fakeecommerceapp.core.data.network.service.ProductsService
import java.net.URLDecoder
import javax.inject.Inject

class RetrofitApiClient @Inject constructor(
    private val categoriesService: CategoriesService,
    private val productsService: ProductsService
) : ApiClient {

    override suspend fun getAllCategories(): List<String> {
        return categoriesService.getCategories()
    }

    override suspend fun getAllProductsInCategory(category: String): List<ProductDTO> {
        return productsService.getAllInCategory(URLDecoder.decode(category))
    }

    override suspend fun getProductById(id: Int): ProductDTO {
        return productsService.getById(id)
    }
}