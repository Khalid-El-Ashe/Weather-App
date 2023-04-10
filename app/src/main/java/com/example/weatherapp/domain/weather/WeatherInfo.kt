package com.example.weatherapp.domain.weather

// this class for information about weather
data class WeatherInfo(
    val weatherDatePerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
