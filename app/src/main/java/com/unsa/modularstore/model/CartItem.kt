package com.unsa.modularstore.model

data class CartItem(
    val product: Product,
    val quantity: Int = 1
)
