package ru.chani.weather

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import ru.chani.weather.screens.MainCard
import ru.chani.weather.screens.TabLayout
import ru.chani.weather.ui.theme.WeatherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme() {
//                for testing
                getData("London", this)

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

//for testing
private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
            API_KEY
    "&q=${city}" +
            "&days=" +
            "4" +
            "&api=no&alerts=no"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            Log.d("LOGGG", response)
        },
        { error ->
            Log.d("LOGGG", error.toString())
        }
    )
    queue.add(sRequest)
}
