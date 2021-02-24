package com.okawa.jetpack.arch.data

import com.okawa.jetpack.arch.data.model.LocationEntity
import io.reactivex.Flowable

interface LocationRepository {

    fun getCurrentLocation(): Flowable<LocationEntity>
}