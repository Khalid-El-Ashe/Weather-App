package com.example.weatherapp.presentation.ui

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.ui.compose.WeatherCard
import com.example.weatherapp.presentation.ui.compose.WeatherForecast
import com.example.weatherapp.presentation.ui.theme.DarkBlue
import com.example.weatherapp.presentation.ui.theme.DeepBlue
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel: WeatherViewModel by viewModels() // i need to make reference to our viewModel
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>> // this element for some permission we needs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // i need to get the permissions
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                viewmodel.loadWeatherInfo()
            }

        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        setContent {
            WeatherAppTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                    ) {
                        WeatherCard(state = viewmodel.state, backgroundColor = DeepBlue)
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(state = viewmodel.state)
                    }

                    // if the view model is loading i need to show progress par
                    if (viewmodel.state.isLoading){
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                    // i need to check if the error not null, mean we have an error
                    viewmodel.state.error?.let { error->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}
