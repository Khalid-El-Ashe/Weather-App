package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mappers.toWeatherInfo
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(private val api: WeatherApi) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(data = api.getWeatherData(lat = lat, long = long).toWeatherInfo())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred...")
        }
    }
}