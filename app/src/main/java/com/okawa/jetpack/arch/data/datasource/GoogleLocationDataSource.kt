package com.okawa.jetpack.arch.data.datasource

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.os.Looper
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.okawa.jetpack.arch.data.model.LocationEntity
import com.okawa.jetpack.arch.utils.PermissionsManager
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

private const val LOCATION_REQUEST_INTERVAL = 1000L * 60 * 5

@Singleton
class GoogleLocationDataSource @Inject constructor(
    private val context: Context,
    private val permissionsManager: PermissionsManager
): LocationDataSource {

    private val locationSubject = PublishSubject.create<LocationEntity>()
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    private val locationRequest: LocationRequest = LocationRequest.create().apply {
        interval = LOCATION_REQUEST_INTERVAL
        //priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        // Use this option whenever uses the emulator, that's the only way to force the emulator
        // GPS to be activated
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    private val locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            locationResult?.locations?.forEach(::setLocation)
        }
    }

    override val locationObservable: Flowable<LocationEntity> = locationSubject
        .toFlowable(BackpressureStrategy.MISSING)
        .doOnSubscribe { startLocationUpdates() }
        .doOnCancel { stopLocationUpdates() }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        if (
            permissionsManager.checkPermissionsGranted(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener(::setLocation)
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        }
    }

    private fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    private fun setLocation(location: Location) {
        val locationEntity = location.toEntity(context = context)
        locationSubject.onNext(locationEntity)
    }
}

private fun Location.toEntity(context: Context): LocationEntity {
    val geocoder = Geocoder(context)
    var country = ""
    var city = ""

    geocoder.getFromLocation(latitude, longitude, 1).firstOrNull()?.let { address ->
        country = address.countryName
        city = address.locality
    }
    return LocationEntity(
        latitude = latitude,
        longitude = longitude,
        country = country,
        city = city
    )
}