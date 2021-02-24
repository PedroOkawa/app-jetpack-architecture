package com.okawa.jetpack.arch.current.domain

import com.okawa.jetpack.arch.domain.WeatherDomain

data class CurrentWeatherDomain(
    val latitude: Double,
    val longitude: Double,
    val temperature: Float,
    val temperatureMin: Float,
    val temperatureMax: Float,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Float,
    val windDegree: Int,
    val sunriseTime: Long,
    val sunsetTime: Long,
    val clouds: Int,
    val country: String,
    val city: String,
    val weathers: List<WeatherDomain>
)
