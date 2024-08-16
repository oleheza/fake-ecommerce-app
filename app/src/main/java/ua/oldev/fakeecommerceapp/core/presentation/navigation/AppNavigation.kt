package ua.oldev.fakeecommerceapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.oldev.fakeecommerceapp.categories.presentation.CategoriesListScreen
import ua.oldev.fakeecommerceapp.categories.presentation.CategoriesListViewModel
import ua.oldev.fakeecommerceapp.products.presentation.details.ProductDetailsScreen
import ua.oldev.fakeecommerceapp.products.presentation.details.ProductDetailsViewModel
import ua.oldev.fakeecommerceapp.products.presentation.list.ProductListScreen
import ua.oldev.fakeecommerceapp.products.presentation.list.ProductListViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: Destination
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination.fullRoute
    ) {

        composable(Categories.fullRoute) {
            val viewModel = hiltViewModel<CategoriesListViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            CategoriesListScreen(
                state = state,
                onAction = viewModel::onAction,
                onCategoryClick = remember {
                    { category ->
                        navHostController.navigate(Products(category))
                    }
                }
            )
        }

        composable(Products.fullRoute) {
            val viewModel = hiltViewModel<ProductListViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            ProductListScreen(
                state = state,
                onAction = viewModel::onAction,
                onProductClick = remember {
                    { productId ->
                        navHostController.navigate(ProductDetails(productId))
                    }
                },
                onBackClick = remember {
                    {
                        navHostController.navigateUp()
                    }
                }
            )
        }

        composable(ProductDetails.fullRoute) {
            val viewModel = hiltViewModel<ProductDetailsViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            ProductDetailsScreen(
                state = state,
                onAction = viewModel::onAction,
                onBackClick = remember {
                    {
                        navHostController.navigateUp()
                    }
                }
            )
        }
    }
}