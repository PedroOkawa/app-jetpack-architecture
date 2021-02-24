package com.okawa.jetpack.arch.current.ui.model

import com.okawa.jetpack.arch.ui.model.Weather

data class CurrentWeather(
    val latitude: Double,
    val longitude: Double,
    val temperature: Float,
    val temperatureMin: Float,
    val temperatureMax: Float,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Float,
    val windDegree: Int,
    val country: String,
    val sunriseTime: Long,
    val sunsetTime: Long,
    val clouds: Int,
    val cityName: String,
    val weathers: List<Weather>
)
