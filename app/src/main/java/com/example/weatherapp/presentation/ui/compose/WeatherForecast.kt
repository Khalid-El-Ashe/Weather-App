package com.example.weatherapp.presentation.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.weather.WeatherData
import com.example.weatherapp.presentation.viewModel.WeatherState

@Composable
fun WeatherForecast(state: WeatherState, modifier: Modifier = Modifier) {
    state.weatherInfo?.weatherDatePerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Toady", style = TextStyle(fontSize = 20.sp, color = Color.White))
            Spacer(modifier = Modifier.height(16.dp))

            // in here i need to make Horuzontel Recycler View
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier.height(100.dp).padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}