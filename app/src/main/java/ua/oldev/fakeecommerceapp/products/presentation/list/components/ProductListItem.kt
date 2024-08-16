package ua.oldev.fakeecommerceapp.products.presentation.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ua.oldev.fakeecommerceapp.core.presentation.fakeProduct2
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

@Composable
fun ProductListItem(
    modifier: Modifier = Modifier,
    productModel: ProductModel
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier.aspectRatio(1f),
                contentScale = ContentScale.FillBounds,
                model = productModel.image,
                contentDescription = "${productModel.title} image",
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = productModel.title,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
private fun ProductListItemPreview() {
    ComposeFakeEcommerceAppTheme {
        ProductListItem(productModel = fakeProduct2)
    }
}