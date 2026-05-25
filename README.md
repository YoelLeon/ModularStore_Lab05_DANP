# Modular Store App

Aplicación móvil desarrollada en **Kotlin** con **Jetpack Compose**, orientada a demostrar el uso de una **UI modular basada en componentes reutilizables**. El proyecto parte de una tienda simple de productos tecnológicos y la amplía con búsqueda dinámica, categorías, favoritos, carrito de compras, pantalla de detalle enriquecida y selección de temas visuales.

Este proyecto corresponde al **Lab 5 - UI Modular: Componentes Reutilizables** del curso **Desarrollo Avanzado en Nuevas Plataformas**.

---

## Objetivo del proyecto

El objetivo principal es construir una interfaz separada en componentes pequeños, configurables y reutilizables, evitando una pantalla monolítica con toda la lógica mezclada. Para ello, la aplicación organiza la UI en componentes, pantallas, modelos, navegación y tema visual.

La idea central aplicada es:

> La interfaz se describe a partir del estado actual de la aplicación.

Por eso, la app maneja estados como productos filtrados, categoría seleccionada, favoritos, elementos del carrito y tema activo.

---

## Funcionalidades implementadas

| Requisito del laboratorio | Implementación en el proyecto |
|---|---|
| App base del docente | `HomeScreen`, `DetailScreen` y `AppNavigation` |
| Componente `CategoryCard` reutilizable | `CategoryCard.kt`, usando `Card`, `Modifier` y colores del tema |
| Cuarto tema libre | Tema `RED`, con colores rojos, fondo propio y tipografía serif |
| Pantalla de favoritos | `FavoritesScreen.kt`, con estado vacío y lista de productos favoritos |
| Carrito de compras | `CartScreen.kt`, con cantidades, total y confirmación de compra |
| SearchBar dinámica | `SearchBar.kt`, con filtrado usando `derivedStateOf` en `HomeScreen` |
| Pantalla detalle con más información | `DetailScreen.kt`, con emoji grande, descripción completa, especificaciones y snackbar |

---

## Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **Gradle Kotlin DSL**
- **Android Studio**

---

## Estructura del proyecto

```text
ModularStore/
├── app/
│   ├── src/main/java/com/unsa/modularstore/
│   │   ├── MainActivity.kt
│   │   ├── model/
│   │   │   ├── AppState.kt
│   │   │   ├── CartItem.kt
│   │   │   └── Product.kt
│   │   ├── navigation/
│   │   │   └── AppNavigation.kt
│   │   └── ui/
│   │       ├── components/
│   │       │   ├── AppButton.kt
│   │       │   ├── AppToolbar.kt
│   │       │   ├── CategoryCard.kt
│   │       │   ├── ProductCard.kt
│   │       │   ├── SearchBar.kt
│   │       │   └── ThemeSelector.kt
│   │       ├── screens/
│   │       │   ├── CartScreen.kt
│   │       │   ├── DetailScreen.kt
│   │       │   ├── FavoritesScreen.kt
│   │       │   └── HomeScreen.kt
│   │       └── theme/
│   │           ├── Color.kt
│   │           ├── Theme.kt
│   │           └── Type.kt
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/
```

---

## Descripción de módulos principales

### `model/`

Contiene las clases y datos principales de la aplicación.

- `Product.kt`: define el modelo de producto y la lista de productos de prueba.
- `CartItem.kt`: representa un producto dentro del carrito junto con su cantidad.
- `AppState.kt`: maneja el estado global de favoritos y carrito.

### `ui/components/`

Contiene componentes reutilizables de la interfaz. Estos componentes reciben datos por parámetros y pueden usarse en distintas pantallas.

- `AppButton`: botón principal reutilizable.
- `AppOutlinedButton`: botón secundario con borde.
- `AppToolbar`: barra superior con título, botón de retroceso y acceso al carrito.
- `ProductCard`: tarjeta reutilizable para mostrar productos.
- `CategoryCard`: tarjeta reutilizable para filtrar productos por categoría.
- `SearchBar`: campo de búsqueda dinámico.
- `ThemeSelector`: selector de temas visuales.

### `ui/screens/`

Contiene las pantallas principales de la aplicación.

- `HomeScreen`: pantalla principal con productos, búsqueda, categorías y selector de tema.
- `DetailScreen`: pantalla de detalle del producto.
- `FavoritesScreen`: pantalla de productos favoritos.
- `CartScreen`: pantalla de carrito de compras.

### `ui/theme/`

Define el sistema visual de la app.

- `Color.kt`: colores principales de cada tema.
- `Theme.kt`: configuración de `MaterialTheme` y modos de tema.
- `Type.kt`: tipografías por defecto y tipografía serif para el tema rojo.

### `navigation/`

Contiene la navegación entre pantallas.

- `AppNavigation.kt`: define las rutas `home`, `detail/{productId}`, `favorites` y `cart`.

---

## Temas disponibles

La aplicación permite cambiar dinámicamente entre cuatro temas:

1. **Blue**
2. **Green**
3. **Purple**
4. **Red**

El tema **Red** fue agregado como cuarto tema libre del laboratorio. Además de cambiar el color principal, también modifica el fondo y utiliza una tipografía serif, diferenciándose visualmente de los otros temas.

---

## Funcionalidades principales

### Búsqueda dinámica

La pantalla principal incluye una barra de búsqueda que permite filtrar productos por nombre o descripción. El filtrado se realiza en tiempo real y se optimiza mediante `derivedStateOf`, de modo que la lista solo se recalcula cuando cambia el texto de búsqueda o la categoría seleccionada.

### Categorías

Los productos pueden filtrarse mediante tarjetas de categoría. Cada `CategoryCard` muestra un emoji, el nombre de la categoría y la cantidad de productos disponibles en esa categoría.

### Favoritos

Cada producto puede marcarse como favorito desde la tarjeta o desde la pantalla de detalle. Los productos favoritos se almacenan en `AppState.favorites` y se muestran en `FavoritesScreen`.

### Carrito de compras

El carrito permite agregar productos, aumentar o disminuir cantidades, ver el total acumulado y confirmar la compra. Al confirmar, el carrito se limpia y se muestra un mensaje de éxito.

### Pantalla de detalle

La pantalla de detalle muestra información ampliada del producto, incluyendo:

- Imagen representada con emoji grande.
- Nombre del producto.
- Categoría.
- Precio.
- Descripción completa.
- Especificaciones simuladas.
- Acción para agregar al carrito.
- Mensaje `Snackbar` al agregar un producto.

---



## Requisitos para ejecutar el proyecto

Antes de ejecutar la aplicación, se recomienda tener instalado:

- Android Studio actualizado.
- JDK compatible con Android Studio.
- SDK de Android configurado.
- Emulador Android o dispositivo físico conectado.

Configuración principal del proyecto:

```text
compileSdk = 35
minSdk = 30
targetSdk = 35
Kotlin = 2.0.21
AGP = 8.7.3
Jetpack Compose BOM = 2024.11.00
```

---

## Cómo ejecutar

1. Abrir el proyecto `ModularStore` en Android Studio.
2. Esperar la sincronización de Gradle.
3. Seleccionar un emulador o dispositivo físico.
4. Ejecutar la aplicación desde el botón **Run**.

También se puede compilar desde terminal, si el proyecto tiene Gradle Wrapper disponible:

```bash
./gradlew :app:assembleDebug
```

En Windows:

```bash
gradlew.bat :app:assembleDebug
```

---

## Flujo básico de uso

1. Al abrir la app, se muestra la pantalla principal con los productos disponibles.
2. El usuario puede cambiar el tema visual desde el selector superior.
3. Puede buscar productos mediante la barra de búsqueda.
4. Puede filtrar productos por categoría.
5. Puede marcar productos como favoritos.
6. Puede ingresar al detalle de un producto.
7. Puede agregar productos al carrito.
8. Desde el carrito, puede modificar cantidades y confirmar la compra.

---

## Principios aplicados de UI modular

El proyecto aplica los siguientes principios trabajados en el laboratorio:

- Separación entre pantallas y componentes.
- Reutilización de componentes comunes.
- Uso de parámetros para evitar datos quemados.
- Uso de `Modifier` externo para personalizar componentes.
- Estado compartido para favoritos y carrito.
- Navegación declarativa con Navigation Compose.
- Consistencia visual mediante `MaterialTheme`.
- Componentes configurables y de responsabilidad clara.

---

## Posibles mejoras futuras

Algunas mejoras que podrían agregarse en versiones posteriores son:

- Persistencia local con Room o DataStore.
- Uso de imágenes reales en lugar de emojis.
- Pantalla de checkout más completa.
- Validación de stock disponible.
- Historial de compras.
- Animaciones entre pantallas.
- Pruebas unitarias y pruebas de UI.

---

## Autor

**Joel Isaias Condori Leon**  
Universidad Nacional de San Agustín de Arequipa  
Escuela Profesional de Ingeniería de Sistemas  
Curso: Desarrollo Avanzado en Nuevas Plataformas

---

## Estado del proyecto

Proyecto desarrollado como práctica académica para demostrar el uso de componentes reutilizables y organización modular en Jetpack Compose.

