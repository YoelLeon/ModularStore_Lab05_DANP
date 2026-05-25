package com.unsa.modularstore.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val category: String = "General",
    val imageEmoji: String = "📦",
    val isFavorite: Boolean = false
)

// Datos de muestra usados en toda la app
val sampleProducts = listOf(
    Product(1, "Laptop Gamer", "RTX 4070 + Ryzen 9, 32GB RAM, SSD 1TB. Ideal para gaming y desarrollo.", 2500.0, "Computadoras", "💻"),
    Product(2, "Mechanical Keyboard", "Switch Blue RGB, TKL, Anti-ghosting. Respuesta táctil perfecta.", 120.0, "Periféricos", "⌨️"),
    Product(3, "Gaming Mouse", "16000 DPI, 7 botones programables, sensor óptico de precisión.", 75.0, "Periféricos", "🖱️"),
    Product(4, "Monitor 4K", "27 pulgadas, 144Hz, IPS, HDR400. Colores vibrantes y sin lag.", 650.0, "Monitores", "🖥️"),
    Product(5, "Auriculares Pro", "Sonido 7.1 virtual, micrófono retráctil, diadema acolchada.", 95.0, "Audio", "🎧"),
    Product(6, "Webcam Full HD", "1080p 60fps, autofocus, micrófono integrado con cancelación de ruido.", 85.0, "Periféricos", "📷"),
    Product(7, "SSD NVMe 1TB", "Velocidad lectura 7000 MB/s, PCIe 4.0, compatible con PS5.", 110.0, "Almacenamiento", "💾"),
    Product(8, "GPU RTX 4080", "16GB GDDR6X, ray tracing, DLSS 3. Para el gamer más exigente.", 1200.0, "Componentes", "🎮"),
)

val sampleCategories = listOf("Todos", "Computadoras", "Periféricos", "Monitores", "Audio", "Almacenamiento", "Componentes")
