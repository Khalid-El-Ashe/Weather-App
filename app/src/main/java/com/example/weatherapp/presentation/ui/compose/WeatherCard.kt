package com.example.weatherapp.presentation.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.viewModel.WeatherState
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@SuppressLint("NewApi")
@Composable
fun WeatherCard(state: WeatherState, backgroundColor: Color, modifier: Modifier = Modifier) {
    // i need to check if the data if is state is actually not null
    state.weatherInfo?.currentWeatherData?.let { weatherData ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                    modifier = Modifier.align(
                        Alignment.End
                    ), color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = weatherData.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${weatherData.temperatureCelsius}°C",
                    style = TextStyle(fontSize = 50.sp, color = Color.White)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${weatherData.weatherType.weatherDesc}",
                    style = TextStyle(fontSize = 20.sp, color = Color.White)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = weatherData.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTent = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = weatherData.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTent = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = weatherData.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTent = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                }
            }
        }

    }

}