package com.unsa.modularstore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.unsa.modularstore.model.AppState
import com.unsa.modularstore.model.Product
import com.unsa.modularstore.model.sampleCategories
import com.unsa.modularstore.model.sampleProducts
import com.unsa.modularstore.ui.components.AppToolbar
import com.unsa.modularstore.ui.components.CategoryCard
import com.unsa.modularstore.ui.components.ProductCard
import com.unsa.modularstore.ui.components.SearchBar
import com.unsa.modularstore.ui.components.ThemeSelector
import com.unsa.modularstore.ui.theme.AppThemeMode

@Composable
fun HomeScreen(
    navController: NavController,
    currentTheme: AppThemeMode,
    onThemeChange: (AppThemeMode) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Todos") }
    val cartCount = AppState.cartItems.sumOf { it.quantity }

    // derivedStateOf: solo recalcula cuando cambia query o categoría
    val filteredProducts by remember {
        derivedStateOf {
            sampleProducts.filter { product ->
                val matchesQuery = searchQuery.isBlank() ||
                        product.name.contains(searchQuery, ignoreCase = true) ||
                        product.description.contains(searchQuery, ignoreCase = true)
                val matchesCategory = selectedCategory == "Todos" ||
                        product.category == selectedCategory
                matchesQuery && matchesCategory
            }
        }
    }

    // Emoji por categoría
    val categoryEmoji = mapOf(
        "Todos" to "🏪", "Computadoras" to "💻", "Periféricos" to "🖱️",
        "Monitores" to "🖥️", "Audio" to "🎧", "Almacenamiento" to "💾",
        "Componentes" to "🎮"
    )

    Scaffold(
        topBar = {
            AppToolbar(
                title = "Modular Store",
                cartCount = cartCount,
                onCartClick = { navController.navigate("cart") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // Selector de tema
            item {
                ThemeSelector(
                    currentTheme = currentTheme,
                    onThemeSelected = onThemeChange
                )
            }

            // SearchBar
            item {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it }
                )
            }

            // CategoryCards (componente nuevo Lab 5)
            item {
                Text(
                    text = "Categorías",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(sampleCategories) { category ->
                        val count = if (category == "Todos") sampleProducts.size
                        else sampleProducts.count { it.category == category }
                        CategoryCard(
                            emoji = categoryEmoji[category] ?: "📦",
                            categoryName = category,
                            productCount = count,
                            isSelected = selectedCategory == category,
                            onClick = { selectedCategory = category }
                        )
                    }
                }
            }

            // Contador de resultados
            item {
                Text(
                    text = if (filteredProducts.isEmpty()) "Sin resultados"
                    else "${filteredProducts.size} producto(s) encontrado(s)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }

            // Lista de productos filtrada
            if (filteredProducts.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier.padding(32.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("😕 No se encontraron productos", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            } else {
                items(
                    items = filteredProducts,
                    key = { it.id }
                ) { product ->
                    ProductCard(
                        product = product,
                        onViewDetail = { p: Product ->
                            navController.navigate("detail/${p.id}")
                        }
                    )
                }
            }
        }
    }
}
