package com.example.tiowichoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

private val LightColors = lightColors(
    primary = OrangeLight,
    secondary = GreenLight,
    onPrimary = White,
    onSecondary = Black,
    onBackground = GrayDark
)

private val DarkColors = darkColors(
    primary = OrangeLight,
    secondary = GreenLight,
    onPrimary = GrayDark,
    onSecondary = White,
    onBackground = GrayDark
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
