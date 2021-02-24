package com.okawa.jetpack.arch.current.data.repository

import com.okawa.jetpack.arch.current.data.datasource.CurrentWeatherApi
import com.okawa.jetpack.arch.current.data.model.CurrentWeatherEntity
import io.reactivex.Observable
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val currentWeatherApi: CurrentWeatherApi
) : CurrentWeatherRepository {

    override fun getCurrentWeather(query: String, unit: String): Observable<CurrentWeatherEntity> {
        return currentWeatherApi.getCurrentWeather(query, unit)
    }
}