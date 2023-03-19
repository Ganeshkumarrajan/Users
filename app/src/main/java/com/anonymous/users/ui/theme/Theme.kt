package com.anonymous.users.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = mainColor,
    primaryVariant = secondary,
    secondary = lightGray,
    background = lightGrayTwo,
    surface = Color.White,
    onPrimary = lightRed,
    onSecondary = lightRedTwo,
    onBackground = grey,
    onSurface = BackgroundGrey,
    secondaryVariant = LineGrey
)

private val LightColorPalette = lightColors(
    primary = mainColor,
    primaryVariant = secondary,
    secondary = lightGray,
    background = lightGrayTwo,
    surface = Color.White,
    onPrimary = lightRed,
    onSecondary = lightRedTwo,
    onBackground = grey,
    onSurface = BackgroundGrey,
    secondaryVariant = LineGrey)

@Composable
fun UsersTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}