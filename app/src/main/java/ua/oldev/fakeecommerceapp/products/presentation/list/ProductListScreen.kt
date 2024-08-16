package ua.oldev.fakeecommerceapp.products.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.fakeecommerceapp.R
import ua.oldev.fakeecommerceapp.core.presentation.components.CenteredProgressIndicator
import ua.oldev.fakeecommerceapp.core.presentation.components.ErrorScreen
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel
import ua.oldev.fakeecommerceapp.products.presentation.list.components.ProductsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    state: ProductListScreenState,
    onProductClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.products))
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back button"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when {
                state.isLoading -> CenteredProgressIndicator()
                state.failure != null -> ErrorScreen(
                    text = stringResource(id = R.string.failed_to_load_data),
                    onRetry = remember {
                        {

                        }
                    },
                )

                state.products.isEmpty() -> Unit
                else -> ProductsList(
                    products = state.products,
                    onProductClick = onProductClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ComposeFakeEcommerceAppTheme {
        ProductListScreen(
            state = ProductListScreenState(
                products = listOf(
                    ProductModel(id = 0, title = "Product 1", image = ""),
                    ProductModel(id = 1, title = "Product 2", image = ""),
                    ProductModel(id = 2, title = "Product 3", image = ""),
                )
            ),
            onProductClick = {},
            onBackClick = {}
        )
    }
}