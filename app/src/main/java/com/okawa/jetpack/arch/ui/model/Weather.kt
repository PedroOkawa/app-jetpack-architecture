package com.okawa.jetpack.arch.ui.model

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val iconSmall: String,
    val iconMedium: String,
    val iconLarge: String
)