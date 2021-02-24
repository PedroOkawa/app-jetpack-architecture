package com.okawa.jetpack.arch.current.data.model

import com.okawa.jetpack.arch.current.domain.CurrentWeatherDomain
import com.okawa.jetpack.arch.data.model.WeatherEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherEntity(
    @Json(name = "coord")
    val coordinates: CoordinatesEntity,
    @Json(name = "weather")
    val weathers: List<WeatherEntity>,
    @Json(name = "main")
    val main: MainEntity,
    @Json(name = "wind")
    val wind: WindEntity,
    @Json(name = "clouds")
    val clouds: Int,
    @Json(name = "name")
    val cityName: String,
    @Json(name = "sys")
    val system: SystemEntity
) {
    fun toDomain(): CurrentWeatherDomain {
        return CurrentWeatherDomain(
            latitude = coordinates.lat,
            longitude = coordinates.lon,
            temperature = main.temperature,
            temperatureMin = main.temperatureMin,
            temperatureMax = main.temperatureMax,
            pressure = main.pressure,
            humidity = main.humidity,
            windSpeed = wind.speed,
            windDegree = wind.degree,
            sunriseTime = system.sunrise,
            sunsetTime = system.sunset,
            country = system.country,
            city = cityName,
            clouds = clouds,
            weathers = weathers.map { it.toDomain() }
        )
    }
}

@JsonClass(generateAdapter = true)
data class CoordinatesEntity(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
)

@JsonClass(generateAdapter = true)
data class MainEntity(
    @Json(name = "temp")
    val temperature: Float,
    @Json(name = "pressure")
    val pressure: Int,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "temp_min")
    val temperatureMin: Float,
    @Json(name = "temp_max")
    val temperatureMax: Float
)

@JsonClass(generateAdapter = true)
data class WindEntity(
    @Json(name = "speed")
    val speed: Float,
    @Json(name = "deg")
    val degree: Int
)

@JsonClass(generateAdapter = true)
data class SystemEntity(
    @Json(name = "type")
    val type: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "message")
    val message: Float,
    @Json(name = "country")
    val country: String,
    @Json(name = "sunrise")
    val sunrise: Long,
    @Json(name = "sunset")
    val sunset: Long
)
