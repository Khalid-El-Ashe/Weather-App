package com.example.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly") // this name is from json file api
    val weatherData: WeatherDataDto // this element is the data from api
)
