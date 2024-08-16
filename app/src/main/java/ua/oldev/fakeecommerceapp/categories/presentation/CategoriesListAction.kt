package ua.oldev.fakeecommerceapp.categories.presentation

sealed interface CategoriesListAction {
    data object RetryLoading : CategoriesListAction
}