package ru.chani.weather.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.chani.weather.R
import ru.chani.weather.domain.models.WeatherModel
import ru.chani.weather.ui.theme.WhiteLight

@Preview
@Composable
fun MainCard() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = WhiteLight,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "01.03.2023",
                        style = TextStyle(fontSize = 15.sp)
                    )
                    AsyncImage(
                        model = "https://turkmenportal.com/themes/turkmenportal/img/logo_tp.png",
                        contentDescription = "icon",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(end = 8.dp)
                    )

                }
                Text(
                    text = "Ashgabat",
                    style = TextStyle(fontSize = 24.sp),
                )
                Text(
                    text = "45°C",
                    style = TextStyle(fontSize = 65.sp)
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "search"
                        )
                    }
                    Text(
                        text = "24°C / 48°C",
                        style = TextStyle(fontSize = 16.sp)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.refresh),
                            contentDescription = "refresh"
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val selectedTabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            },
            backgroundColor = WhiteLight
        ) {
            tabList.forEachIndexed { index, string ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(text = string) }
                )
            }
        }

        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->
            when (index) {
                0 -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        itemsIndexed(
//                            FAKE-DATA
                            listOf(
                                WeatherModel(
                                    "Ashgabat",
                                    "10:00",
                                    "24°C",
                                    "Sunny",
                                    "//cdn.weatherapi.com/weather/64x64/day/116.png",
                                    "40°C",
                                    "24°C",
                                    ""
                                ),
                                WeatherModel(
                                    "Ashgabat",
                                    "12:00",
                                    "18°C",
                                    "Sunny",
                                    "//cdn.weatherapi.com/weather/64x64/day/116.png",
                                    "40°C",
                                    "24°C",
                                    ""
                                )
                            )
                        ) { _, item ->
                            ru.chani.weather.ListItem(item = item)
                        }
                    }
                }
                1 -> {
                    AsyncImage(
                        model = "https://tmcars.info/tmcars/images/original/2023/03/13/12/17/43239c72-76f3-4555-8cd8-1d9e6a2484cd.jpg",
                        contentDescription = "phone",
                    )
                }
            }
        }
    }
}