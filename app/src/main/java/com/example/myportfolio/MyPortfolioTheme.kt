package com.example.myportfolio.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFB3E5FC),          // pastel blue
    onPrimary = Color.Black,
    secondary = Color(0xFFFFE0B2),        // pastel peach
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = Color.Black
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF81D4FA),          // darker pastel blue
    onPrimary = Color.Black,
    secondary = Color(0xFFFFCC80),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White
)

@Composable
fun MyPortfolioTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
