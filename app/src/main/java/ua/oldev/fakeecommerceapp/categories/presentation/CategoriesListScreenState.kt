package ua.oldev.fakeecommerceapp.categories.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class CategoriesListScreenState(
    val isLoading: Boolean = false,
    val failure: Throwable? = null,
    val categories: List<String> = emptyList()
)
