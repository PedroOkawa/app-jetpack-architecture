package com.okawa.jetpack.arch.data.model

data class LocationEntity(
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val city: String
)