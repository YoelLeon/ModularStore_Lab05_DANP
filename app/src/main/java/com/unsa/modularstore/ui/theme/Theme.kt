package com.unsa.modularstore.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

enum class AppThemeMode {
    BLUE, GREEN, PURPLE, RED
}

@Composable
fun ModularStoreTheme(
    themeMode: AppThemeMode = AppThemeMode.BLUE,
    content: @Composable () -> Unit
) {
    val colorScheme = when (themeMode) {
        AppThemeMode.BLUE -> lightColorScheme(
            primary = BluePrimary,
            secondary = BlueSecondary,
            background = BlueBackground,
            surface = SurfaceWhite,
            onPrimary = SurfaceWhite,
            onBackground = TextPrimary,
            onSurface = TextPrimary,
        )
        AppThemeMode.GREEN -> lightColorScheme(
            primary = GreenPrimary,
            secondary = GreenSecondary,
            background = GreenBackground,
            surface = SurfaceWhite,
            onPrimary = SurfaceWhite,
            onBackground = TextPrimary,
            onSurface = TextPrimary,
        )
        AppThemeMode.PURPLE -> lightColorScheme(
            primary = PurplePrimary,
            secondary = PurpleSecondary,
            background = PurpleBackground,
            surface = SurfaceWhite,
            onPrimary = SurfaceWhite,
            onBackground = TextPrimary,
            onSurface = TextPrimary,
        )
        AppThemeMode.RED -> lightColorScheme(
            primary = RedPrimary,
            secondary = RedSecondary,
            background = RedBackground,
            surface = SurfaceWhite,
            onPrimary = SurfaceWhite,
            onBackground = TextPrimary,
            onSurface = TextPrimary,
        )
    }

    val typography = if (themeMode == AppThemeMode.RED) RedTypography else DefaultTypography

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}
