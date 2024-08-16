package ua.oldev.fakeecommerceapp.products.presentation.list

sealed interface ProductListAction {
    data object RetryLoading : ProductListAction
}