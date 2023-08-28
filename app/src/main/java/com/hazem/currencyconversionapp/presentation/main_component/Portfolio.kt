package com.hazem.currencyconversionapp.presentation.main_component

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails


@Composable
fun Portfolio(
    list:List<CurrencyDetails>,
    navController: NavController
) {



        Log.d("eee", "entered")
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "live exchange rates",
                    style = TextStyle(
                        fontSize = 17.sp,
                        // fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                    ), modifier = Modifier.weight(3f)
                )

                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(20.dp),
                            color = Color.Black
                        )
                        .weight(2f)
                        .clickable { navController.navigate("favorite") }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.AddCircleOutline,
                            contentDescription = "add Favorite",
                            modifier = Modifier.padding(5.dp)
                        )
                        Text(
                            text = "Add to Favorites",
                            style = TextStyle(
                                fontSize = 10.87.sp,
                                //fontFamily = FontFamily(Font(R.font.poppins)),
                                fontWeight = FontWeight(500),
                                color = Color.Black,
                            )
                        )
                    }
                }
            }

            Text(
                text = "My Portfolio",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    // fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                ), modifier = Modifier.padding(10.dp)
            )
            Column {
                repeat(list.size) { i ->
                    PortfolioItem(
                        imageUrl = list[i].flag,
                        currency = list[i].currency,
                        exchangeRate = list[i].exchangeRate
                    )
                }
            }
        }
    }


