package com.okawa.jetpack.arch.current.domain

import com.okawa.jetpack.arch.current.data.repository.CurrentWeatherRepository
import com.okawa.jetpack.arch.data.LocationRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val currentWeatherRepository: CurrentWeatherRepository,
    private val locationRepository: LocationRepository
) {

    fun execute(unit: String): Flowable<CurrentWeatherDomain> {
        return locationRepository
            .getCurrentLocation()
            .flatMap { locationEntity ->
                currentWeatherRepository
                    .getCurrentWeather(locationEntity.city, unit)
                    .toFlowable(BackpressureStrategy.ERROR)
            }
            .map { currentWeatherRepository ->
                currentWeatherRepository.toDomain()
            }
    }
}