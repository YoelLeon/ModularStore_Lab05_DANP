package com.unsa.modularstore.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

// Estado global de favoritos y carrito compartido entre pantallas
object AppState {
    val favorites: SnapshotStateList<Product> = mutableStateListOf()
    val cartItems: SnapshotStateList<CartItem> = mutableStateListOf()

    fun toggleFavorite(product: Product) {
        val existing = favorites.find { it.id == product.id }
        if (existing != null) favorites.remove(existing)
        else favorites.add(product)
    }

    fun isFavorite(product: Product): Boolean =
        favorites.any { it.id == product.id }

    fun addToCart(product: Product) {
        val existing = cartItems.find { it.product.id == product.id }
        if (existing != null) {
            val index = cartItems.indexOf(existing)
            cartItems[index] = existing.copy(quantity = existing.quantity + 1)
        } else {
            cartItems.add(CartItem(product))
        }
    }

    fun removeFromCart(product: Product) {
        val existing = cartItems.find { it.product.id == product.id }
        if (existing != null) {
            if (existing.quantity > 1) {
                val index = cartItems.indexOf(existing)
                cartItems[index] = existing.copy(quantity = existing.quantity - 1)
            } else {
                cartItems.remove(existing)
            }
        }
    }

    fun cartTotal(): Double = cartItems.sumOf { it.product.price * it.quantity }

    fun cartCount(): Int = cartItems.sumOf { it.quantity }
}
