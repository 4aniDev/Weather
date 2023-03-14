package ru.chani.weather

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.chani.weather.domain.models.WeatherModel
import ru.chani.weather.ui.theme.Purple700
import ru.chani.weather.ui.theme.WhiteLight

@Composable
fun ListItem(item: WeatherModel) {
    Card(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth(),
        backgroundColor = WhiteLight,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(3.dp)
        )
        {
            Column {
                Text(text = item.time)
                Text(text = item.condition, color = Purple700)
            }
            Text(
                text = item.currentTemp.ifEmpty { "${item.maxTemp} / ${item.minTemp}" },
                fontSize = 30.sp
            )
            AsyncImage(
                model = "https:${item.icon}",
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }
    }

}