package ru.chani.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.chani.weather.screens.MainCard
import ru.chani.weather.screens.TabLayout
import ru.chani.weather.ui.theme.WeatherTheme

const val API_KEY = "d4f6f14308e54a9880f62118232802"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme() {
                Image(
                    painter = painterResource(id = R.drawable.bg),
                    contentDescription = "background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.8f)
                )
                Column() {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}
