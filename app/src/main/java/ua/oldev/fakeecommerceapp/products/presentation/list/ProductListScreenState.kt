package ua.oldev.fakeecommerceapp.products.presentation.list

import androidx.compose.runtime.Immutable
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

@Immutable
data class ProductListScreenState(
    val isLoading: Boolean = false,
    val failure: Throwable? = null,
    val products: List<ProductModel> = emptyList()
)
