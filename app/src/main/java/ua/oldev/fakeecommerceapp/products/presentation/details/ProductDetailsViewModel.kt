package ua.oldev.fakeecommerceapp.products.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.oldev.fakeecommerceapp.core.presentation.navigation.ProductDetails.PRODUCT_ID_KEY
import ua.oldev.fakeecommerceapp.products.domain.mapper.toModel
import ua.oldev.fakeecommerceapp.products.domain.repository.ProductsRepository
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val productId = savedStateHandle.get<String>(PRODUCT_ID_KEY).orEmpty().toInt()

    val state: StateFlow<ProductDetailsScreenState>
        get() = internalState.asStateFlow()

    private val internalState = MutableStateFlow(ProductDetailsScreenState())

    init {
        loadProductDetails()
    }

    private fun loadProductDetails() {
        internalState.update { state -> state.copy(isLoading = true, failure = null) }
        viewModelScope.launch {
            val result = productsRepository.getById(productId)

            result.fold(
                onSuccess = { product ->
                    internalState.update { state ->
                        state.copy(
                            isLoading = false,
                            productModel = product?.toModel()
                        )
                    }
                },
                onFailure = { failure ->
                    internalState.update { state ->
                        state.copy(
                            isLoading = false,
                            failure = failure
                        )
                    }
                }
            )
        }
    }
}