package ua.oldev.fakeecommerceapp.products.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ua.oldev.fakeecommerceapp.R
import ua.oldev.fakeecommerceapp.core.presentation.fakeProduct1
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

@Composable
fun ProductDetails(
    modifier: Modifier = Modifier,
    productModel: ProductModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(
                    RoundedCornerShape(
                        topEnd = 0f,
                        topStart = 0f,
                        bottomEnd = 70f,
                        bottomStart = 70f
                    )
                ),
            model = productModel.image,
            contentDescription = "Product ${productModel.title} heading image"
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = productModel.title,
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "$${productModel.price}",
                style = MaterialTheme.typography.titleMedium
            )
            Row {
                PartiallyFilledStar(rating = productModel.calculateRating())
                Text(
                    text = productModel.rate.toString()
                )
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = stringResource(
                        id = R.string.reviews_count_text,
                        productModel.ratingCount
                    )
                )
            }
        }
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = productModel.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun ProductDetailsPreview() {
    ComposeFakeEcommerceAppTheme {
        ProductDetails(productModel = fakeProduct1)
    }
}