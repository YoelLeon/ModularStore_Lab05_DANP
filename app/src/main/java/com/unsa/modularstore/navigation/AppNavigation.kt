package com.unsa.modularstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.unsa.modularstore.ui.screens.CartScreen
import com.unsa.modularstore.ui.screens.DetailScreen
import com.unsa.modularstore.ui.screens.FavoritesScreen
import com.unsa.modularstore.ui.screens.HomeScreen
import com.unsa.modularstore.ui.theme.AppThemeMode
import com.unsa.modularstore.ui.theme.ModularStoreTheme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var currentTheme by remember { mutableStateOf(AppThemeMode.BLUE) }

    ModularStoreTheme(themeMode = currentTheme) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    navController = navController,
                    currentTheme = currentTheme,
                    onThemeChange = { currentTheme = it }
                )
            }

            composable(
                route = "detail/{productId}",
                arguments = listOf(
                    navArgument("productId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                DetailScreen(
                    productId = productId,
                    navController = navController
                )
            }

            composable("favorites") {
                FavoritesScreen(navController = navController)
            }

            composable("cart") {
                CartScreen(navController = navController)
            }
        }
    }
}
