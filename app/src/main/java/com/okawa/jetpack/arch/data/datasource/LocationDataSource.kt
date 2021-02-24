package com.okawa.jetpack.arch.data.datasource

import com.okawa.jetpack.arch.data.model.LocationEntity
import io.reactivex.Flowable

interface LocationDataSource {

    val locationObservable: Flowable<LocationEntity>
}