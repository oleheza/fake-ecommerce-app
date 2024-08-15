package ua.oldev.fakeecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ua.oldev.fakeecommerceapp.core.presentation.navigation.AppNavigation
import ua.oldev.fakeecommerceapp.core.presentation.navigation.Categories
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFakeEcommerceAppTheme {
                AppNavigation(
                    navHostController = rememberNavController(),
                    startDestination = Categories
                )
            }
        }
    }
}