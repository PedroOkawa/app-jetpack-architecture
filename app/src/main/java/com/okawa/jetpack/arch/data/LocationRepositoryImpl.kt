package com.okawa.jetpack.arch.data

import com.okawa.jetpack.arch.data.datasource.LocationDataSource
import com.okawa.jetpack.arch.data.model.LocationEntity
import io.reactivex.Flowable
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource
) : LocationRepository {

    override fun getCurrentLocation(): Flowable<LocationEntity> = locationDataSource.locationObservable
}