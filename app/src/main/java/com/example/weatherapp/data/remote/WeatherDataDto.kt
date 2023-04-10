package com.example.weatherapp.data.remote

import com.squareup.moshi.Json

// this class is the data for weather from api
data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m") // this name is from json file api
    val temperatures: List<Double>,
    @field:Json(name = "weathercode") // this name is from json file api
    val weatherCodes: List<Int>,
    @field:Json(name = "pressure_msl") // this name is from json file api
    val pressure: List<Double>,
    @field:Json(name = "windspeed_10m") // this name is from json file api
    val windSpeeds: List<Double>,
    @field:Json(name = "relativehumidity_2m") // this name is from json file api
    val humidity: List<Double>
)
