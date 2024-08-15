package ua.oldev.fakeecommerceapp.categories.presentation.components

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme


@Composable
internal fun CategoriesListItem(
    modifier: Modifier = Modifier,
    title: String
) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(text = title)
        }
    )
}

@Preview
@Composable
private fun CategoriesListItemPreview() {
    ComposeFakeEcommerceAppTheme {
        CategoriesListItem(title = "Category 1")
    }
}