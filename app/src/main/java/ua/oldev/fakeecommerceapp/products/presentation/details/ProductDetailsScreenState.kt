package ua.oldev.fakeecommerceapp.products.presentation.details

import androidx.compose.runtime.Immutable
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

@Immutable
data class ProductDetailsScreenState(
    val isLoading: Boolean = false,
    val productModel: ProductModel? = null,
    val failure: Throwable? = null
)
