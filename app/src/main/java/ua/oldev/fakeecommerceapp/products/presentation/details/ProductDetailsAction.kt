package ua.oldev.fakeecommerceapp.products.presentation.details

sealed interface ProductDetailsAction {
    data object RetryLoading : ProductDetailsAction
}