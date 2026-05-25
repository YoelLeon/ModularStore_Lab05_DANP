package com.unsa.modularstore.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unsa.modularstore.ui.theme.AppThemeMode

@Composable
fun ThemeSelector(
    currentTheme: AppThemeMode,
    onThemeSelected: (AppThemeMode) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        AppThemeMode.entries.forEach { mode ->
            val label = when (mode) {
                AppThemeMode.BLUE   -> "Azul"
                AppThemeMode.GREEN  -> "Verde"
                AppThemeMode.PURPLE -> "Morado"
                AppThemeMode.RED    -> "Rojo"
            }
            if (mode == currentTheme) {
                AppButton(
                    text = label,
                    modifier = Modifier.weight(1f),
                    onClick = { onThemeSelected(mode) }
                )
            } else {
                AppOutlinedButton(
                    text = label,
                    modifier = Modifier.weight(1f),
                    onClick = { onThemeSelected(mode) }
                )
            }
        }
    }
}
