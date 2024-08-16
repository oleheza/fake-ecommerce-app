package ua.oldev.fakeecommerceapp.products.presentation.details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme

@Composable
fun PartiallyFilledStar(
    modifier: Modifier = Modifier,
    rating: Float,
    icon: ImageVector = Icons.Default.Star,
    backgroundColor: Color = Color.Gray,
    fillColor: Color = Color.Red
) {
    Box(modifier = modifier) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = backgroundColor
        )
        Icon(
            modifier = Modifier.drawWithContent {
                val fillWidth = size.width * rating
                clipRect(right = fillWidth) {
                    this@drawWithContent.drawContent()
                }
            },
            imageVector = icon,
            contentDescription = null,
            tint = fillColor
        )
    }
}

@Preview
@Composable
private fun PartiallyFilledStarPreview() {
    ComposeFakeEcommerceAppTheme {
        PartiallyFilledStar(rating = 0.6f)
    }
}