package com.example.tiowichoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable

private val LightColors = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariant,
    secondary = SecondaryColor
)

private val DarkColors = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariant,
    secondary = SecondaryColor
)

@Composable
fun TioWichoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}
