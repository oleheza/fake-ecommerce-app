package ua.oldev.fakeecommerceapp.categories.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ua.oldev.fakeecommerceapp.R
import ua.oldev.fakeecommerceapp.categories.presentation.components.CategoriesList
import ua.oldev.fakeecommerceapp.core.presentation.components.CenteredProgressIndicator
import ua.oldev.fakeecommerceapp.core.presentation.components.ErrorScreen
import ua.oldev.fakeecommerceapp.core.presentation.fakeCategories
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesListScreen(
    modifier: Modifier = Modifier,
    state: CategoriesListScreenState,
    onAction: (CategoriesListAction) -> Unit,
    onCategoryClick: (String) -> Unit
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.categories_title))
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when {
                state.isLoading -> CenteredProgressIndicator()
                state.failure != null -> ErrorScreen(
                    text = stringResource(id = R.string.failed_to_load_data),
                    onRetry = remember {
                        {
                            onAction(CategoriesListAction.RetryLoading)
                        }
                    }
                )

                state.categories.isEmpty() -> Unit
                else -> CategoriesList(
                    categories = state.categories,
                    onCategoryClick = onCategoryClick
                )
            }
        }
    }
}


@Preview
@Composable
private fun CategoriesListScreenPreview() {
    ComposeFakeEcommerceAppTheme {
        CategoriesListScreen(
            state = CategoriesListScreenState(
                categories = fakeCategories
            ),
            onAction = {},
            onCategoryClick = {}
        )
    }
}

@Preview
@Composable
private fun CategoriesListScreenFailurePreview() {
    ComposeFakeEcommerceAppTheme {
        CategoriesListScreen(
            state = CategoriesListScreenState(
                failure = Exception()
            ),
            onAction = {},
            onCategoryClick = {}
        )
    }
}