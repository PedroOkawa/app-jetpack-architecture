package com.okawa.jetpack.arch.ui.composable.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightThemeColors = lightColors(
    primary = ColorsLight.primaryColor,
    primaryVariant = ColorsLight.primaryDarkColor,
    onPrimary = ColorsLight.primaryTextColor,
    secondary = ColorsLight.secondaryColor,
    secondaryVariant = ColorsLight.secondaryDarkColor,
    onSecondary = ColorsLight.secondaryTextColor,
    error = ColorsLight.onError
)

private val DarkThemeColors = darkColors(
    primary = ColorsDark.primaryColor,
    primaryVariant = ColorsDark.primaryDarkColor,
    onPrimary = ColorsDark.primaryTextColor,
    secondary = ColorsDark.secondaryColor,
    onSecondary = ColorsDark.secondaryTextColor,
    error = ColorsDark.onError
)

@Composable
fun JetpackArchTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkTheme) DarkThemeColors else LightThemeColors,
        typography = JetpackArchTypography,
        shapes = JetpackArchShapes,
        content = content
    )
}