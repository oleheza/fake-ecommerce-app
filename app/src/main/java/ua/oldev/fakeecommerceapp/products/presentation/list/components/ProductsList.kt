package ua.oldev.fakeecommerceapp.products.presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.oldev.fakeecommerceapp.core.presentation.fakeProducts
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

@Composable
fun ProductsList(
    modifier: Modifier = Modifier,
    products: List<ProductModel>,
    onProductClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            products,
            key = { product -> product.id }
        ) { product ->
            ProductListItem(
                modifier = Modifier.clickable { onProductClick.invoke(product.id) },
                productModel = product
            )
        }
    }
}

@Preview
@Composable
private fun ProductsListPreview() {
    ComposeFakeEcommerceAppTheme {
        ProductsList(
            products = fakeProducts,
            onProductClick = {},
        )
    }
}