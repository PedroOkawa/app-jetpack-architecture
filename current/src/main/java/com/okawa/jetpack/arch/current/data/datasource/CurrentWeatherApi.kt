package com.okawa.jetpack.arch.current.data.datasource

import com.okawa.jetpack.arch.current.data.model.CurrentWeatherEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherApi {

    @GET("/weather")
    fun getCurrentWeather(
        @Query("q") query: String,
        @Query("units") units: String
    ): Observable<CurrentWeatherEntity>
}