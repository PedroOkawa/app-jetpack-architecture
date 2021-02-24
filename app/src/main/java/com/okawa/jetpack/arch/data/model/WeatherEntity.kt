package com.okawa.jetpack.arch.data.model

import com.okawa.jetpack.arch.domain.WeatherDomain
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherEntity(
    @Json(name = "id")
    val id: Int,
    @Json(name = "main")
    val main: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "icon")
    val icon: String
) {

    fun toDomain(): WeatherDomain {
        return WeatherDomain(
            id = id,
            main = main,
            description = description,
            iconSmall = icon,
            iconMedium = "$icon@2x",
            iconLarge = "$icon@4x",
        )
    }
}