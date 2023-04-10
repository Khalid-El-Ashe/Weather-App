package com.example.weatherapp.presentation.viewModel

import com.example.weatherapp.domain.weather.WeatherInfo

// this class for state for the viewModel or ui
data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
