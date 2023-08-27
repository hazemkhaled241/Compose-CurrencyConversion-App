package com.hazem.currencyconversionapp.presentation.main_component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hazem.currencyconversionapp.presentation.currency_conversion.CurrencyConversionViewModel


@Composable
fun Portfolio(currencyConversionViewModel: CurrencyConversionViewModel = hiltViewModel(),
              navController: NavController) {

    Column(modifier = Modifier.padding(24.dp)) {
        Row {
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
                            color = Color(0xFF363636),
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
        LazyColumn {
            currencyConversionViewModel.getAllCurrencyFromFavorite()
            val favListCurrency = mutableListOf<String>()

            currencyConversionViewModel.getAllFavoriteCurrencyState.value.allCurrency.forEach {
                favListCurrency.add(it.currency)
            }

            currencyConversionViewModel.getFavoritesDetails(
                currencyConversionViewModel.state.value.base,
                favListCurrency
            )
            val liveExchangeList = currencyConversionViewModel.currencyDetailsState.value.favorites
            items(liveExchangeList) {
                PortfolioItem(
                    imageUrl = it.flag,
                    currency = it.currency,
                    exchangeRate = it.exchangeRate
                )
            }
        }
    }

}