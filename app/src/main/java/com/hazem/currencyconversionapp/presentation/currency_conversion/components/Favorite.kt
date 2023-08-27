package com.hazem.currencyconversionapp.presentation.currency_conversion.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.presentation.currencies.CurrenciesViewModel
import com.hazem.currencyconversionapp.presentation.currency_conversion.CurrencyConversionViewModel
import com.hazem.currencyconversionapp.presentation.ui.theme.DarkWhite


@Composable
fun Favorite(
    currenciesViewModel: CurrenciesViewModel = hiltViewModel(),
    currencyConversionViewModel: CurrencyConversionViewModel = hiltViewModel(),
    /*  navController: NavController*/
) {
    currencyConversionViewModel.getAllCurrencyFromFavorite()
    val allCurrencies = currenciesViewModel.state.value.currencyList
    var isChecked by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { /*navController.navigate("main") */ },
            modifier = Modifier
                .padding(top = 30.dp, end = 15.dp)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.Close, contentDescription = "close Icon",
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(600.dp)
                .align(Alignment.Center)
                .background(color = DarkWhite, shape = RoundedCornerShape(20.dp))
        ) {
            Text(
                text = "My Favorites",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 23.sp,
                    // fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 30.dp, start = 10.dp)
            )
            LazyColumn {
                itemsIndexed(allCurrencies) { index, item ->
                    FavoriteItem(
                        imageUrl = item.flag,
                        currency = item.currency,
                        selected = currencyConversionViewModel.getAllFavoriteCurrencyState.value.allCurrency
                            .map { it.currency }
                            .contains(item.currency),
                        onChecked = {
                            isChecked = isChecked.not()
                            if (isChecked) {
                                currenciesViewModel
                                    .addCurrencyToFavorite(
                                        CurrencyEntity(id = index, currency = item.currency)

                                    )
                                Log.d("dddff", "added ${item.currency} ")

                            }
                            else{
                            currenciesViewModel
                                .deleteCurrencyToFavorite(
                                    CurrencyEntity(id = index, currency = item.currency)
                                )
                            Log.d("dddff", "delet ${item.currency} ")
                        }}
                    )
                }

            }
        }
    }

}





