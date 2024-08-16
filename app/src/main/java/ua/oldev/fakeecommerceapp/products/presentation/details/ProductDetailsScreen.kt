package ua.oldev.fakeecommerceapp.products.presentation.details

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.fakeecommerceapp.R
import ua.oldev.fakeecommerceapp.core.presentation.components.CenteredProgressIndicator
import ua.oldev.fakeecommerceapp.core.presentation.fakeProduct3
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme
import ua.oldev.fakeecommerceapp.products.presentation.details.components.ProductDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    state: ProductDetailsScreenState,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.product_details))
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back button"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when {
                state.isLoading -> CenteredProgressIndicator()
                state.productModel != null -> ProductDetails(productModel = state.productModel)
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailsScreenPreview() {
    ComposeFakeEcommerceAppTheme {
        ProductDetailsScreen(
            state = ProductDetailsScreenState(productModel = fakeProduct3),
            onBackClick = {}
        )
    }
}