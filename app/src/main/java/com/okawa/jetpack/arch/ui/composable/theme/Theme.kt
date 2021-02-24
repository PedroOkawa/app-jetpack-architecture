package com.okawa.jetpack.arch.ui.composable.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightThemeColors = lightColors(
    primary = ColorsLight.primaryColor,
    primaryVariant = ColorsLight.primaryDarkColor,
    secondary = ColorsLight.secondaryColor,
    secondaryVariant = ColorsLight.secondaryDarkColor,
    background = ColorsLight.primaryLightColor,
    surface = ColorsLight.secondaryLightColor,
    error = ColorsLight.onError,
    onPrimary = ColorsLight.primaryTextColor,
    onSecondary = ColorsLight.secondaryTextColor,
    onBackground = ColorsLight.primaryTextColor,
    onSurface = ColorsLight.secondaryTextColor
)

private val DarkThemeColors = darkColors(
    primary = ColorsDark.primaryColor,
    primaryVariant = ColorsDark.primaryDarkColor,
    secondary = ColorsDark.secondaryColor,
    background = ColorsDark.primaryLightColor,
    surface = ColorsDark.secondaryLightColor,
    error = ColorsDark.onError,
    onPrimary = ColorsDark.primaryTextColor,
    onSecondary = ColorsDark.secondaryTextColor,
    onBackground = ColorsDark.primaryTextColor,
    onSurface = ColorsDark.secondaryTextColor
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