package com.okawa.jetpack.arch.current.ui.currentweather

import androidx.lifecycle.ViewModel
import com.okawa.jetpack.arch.current.ui.model.CurrentWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow<List<CurrentWeather>>(emptyList())
    val state: StateFlow<List<CurrentWeather>>
        get() = _state

}