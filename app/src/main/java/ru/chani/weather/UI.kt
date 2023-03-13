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
import ru.chani.weather.ui.theme.Purple700
import ru.chani.weather.ui.theme.WhiteLight

@Preview(showBackground = true)
@Composable
fun ListItem() {
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
                Text(text = "12:00")
                Text(text = "Sunday", color = Purple700)
            }
            Text(text = "25°C", fontSize = 30.sp)
            AsyncImage(model = "https://cdn.weatherapi.com/weather/64x64/day/116.png", contentDescription = "", modifier = Modifier.size(50.dp))
        }
    }

}