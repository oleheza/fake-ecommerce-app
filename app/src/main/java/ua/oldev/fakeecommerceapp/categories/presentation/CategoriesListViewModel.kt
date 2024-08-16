package ua.oldev.fakeecommerceapp.categories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.oldev.fakeecommerceapp.categories.domain.repository.CategoriesRepository
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) : ViewModel() {

    val state: StateFlow<CategoriesListScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(CategoriesListScreenState())

    init {
        loadCategories()
    }

    fun onAction(action: CategoriesListAction) {
        when (action) {
            CategoriesListAction.RetryLoading -> loadCategories()
        }
    }

    private fun loadCategories() {
        internalState.update { state -> state.copy(isLoading = true, failure = null) }
        viewModelScope.launch {
            val result = categoriesRepository.getCategories()

            result.fold(
                onSuccess = { categories ->
                    internalState.update { state ->
                        state.copy(
                            isLoading = false,
                            categories = categories
                        )
                    }
                },
                onFailure = { throwable ->
                    internalState.update { state ->
                        state.copy(
                            isLoading = false,
                            failure = throwable
                        )
                    }
                }
            )
        }
    }
}