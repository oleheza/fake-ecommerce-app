package ua.oldev.fakeecommerceapp.categories.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme

@Composable
internal fun CategoriesList(
    modifier: Modifier = Modifier,
    categories: List<String>,
    onCategoryClick: (String) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(categories) { item ->
            CategoriesListItem(
                modifier = Modifier.clickable { onCategoryClick.invoke(item) },
                title = item
            )
        }
    }
}

@Preview
@Composable
private fun CategoriesListPreview() {
    ComposeFakeEcommerceAppTheme {
        CategoriesList(
            categories = listOf("Category 1", "Category 2"),
            onCategoryClick = {}
        )
    }
}