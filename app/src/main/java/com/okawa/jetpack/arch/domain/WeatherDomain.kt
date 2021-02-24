package com.okawa.jetpack.arch.domain

data class WeatherDomain(
    val id: Int,
    val main: String,
    val description: String,
    val iconSmall: String,
    val iconMedium: String,
    val iconLarge: String
)