package ua.oldev.fakeecommerceapp.products.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.oldev.fakeecommerceapp.core.presentation.navigation.Products.CATEGORY_ID_KEY
import ua.oldev.fakeecommerceapp.products.domain.mapper.toModel
import ua.oldev.fakeecommerceapp.products.domain.repository.ProductsRepository
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository
) : ViewModel() {

    val category = savedStateHandle.get<String>(CATEGORY_ID_KEY).orEmpty()

    val state: StateFlow<ProductListScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(ProductListScreenState())

    init {
        loadProducts()
    }

    fun onAction(action: ProductListAction) {
        when (action) {
            ProductListAction.RetryLoading -> loadProducts()
        }
    }

    private fun loadProducts() {
        internalState.update { state -> state.copy(isLoading = true, failure = null) }
        viewModelScope.launch {
            val result = productsRepository.getAllInCategory(category)

            result.fold(
                onSuccess = { products ->
                    internalState.update { state ->
                        state.copy(
                            isLoading = false,
                            products = products.map { product -> product.toModel() }
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