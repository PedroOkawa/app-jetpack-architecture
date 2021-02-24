package com.okawa.jetpack.arch.current.data.repository

import com.okawa.jetpack.arch.current.data.model.CurrentWeatherEntity
import io.reactivex.Observable

interface CurrentWeatherRepository {
    fun getCurrentWeather(
        query: String,
        unit: String
    ): Observable<CurrentWeatherEntity>
}