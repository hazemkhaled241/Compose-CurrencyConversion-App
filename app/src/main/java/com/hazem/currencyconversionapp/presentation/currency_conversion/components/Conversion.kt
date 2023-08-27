package com.hazem.currencyconversionapp.presentation.currency_conversion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hazem.currencyconversionapp.presentation.main_component.CurrencyMenu
import com.hazem.currencyconversionapp.presentation.currency_conversion.CurrencyConversionViewModel
import com.hazem.currencyconversionapp.presentation.main_component.Currencies
import com.hazem.currencyconversionapp.presentation.ui.theme.DarkWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Conversion(currencyConversionViewModel: CurrencyConversionViewModel = hiltViewModel()) {

    Column(

        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 50.dp)
    ) {

        Row(horizontalArrangement = Arrangement.Start) {
            Text(
                text = "Amount",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ),
                modifier = Modifier.weight(1f)

            )
            Text(
                text = "From",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ),
                modifier = Modifier.weight(2f)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(horizontalArrangement = Arrangement.Start) {
            OutlinedTextField(
                value = currencyConversionViewModel.state.value.amount, onValueChange = {
                    currencyConversionViewModel.setAmountState(it)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(size = 20.dp),
                modifier = Modifier
                    .padding(end = 15.dp)
                    .border(
                        width = 0.5.dp, color = Color(0xFFC5C5C5),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 20.dp)
                    )
            )
            CurrencyMenu(
                currency = Currencies(currencyConversionViewModel.state.value.base ,
                    currencyConversionViewModel.state.value.painterBase),
                onItemClicked = { base ->
                    currencyConversionViewModel.state.value.base = base
                }, modifier = Modifier
                    .weight(2f)
                    .height(50.dp)
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(20.dp),
                        color = DarkWhite
                    )

            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            Text(
                text = "To",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ),
                modifier = Modifier.weight(2f)

            )
            Text(
                text = "Amount",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            CurrencyMenu(
                currency = Currencies(currencyConversionViewModel.state.value.target ,
                    currencyConversionViewModel.state.value.painterTarget),
                onItemClicked = { target ->
                    currencyConversionViewModel.state.value.target = target
                },
                modifier = Modifier
                    .weight(2f)
                    .height(52.dp)
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(20.dp),
                        color = DarkWhite
                    )
            )
            OutlinedTextField(
                value = currencyConversionViewModel.state.value.value.toString(),
                onValueChange = {},
                readOnly = true,

                modifier = Modifier
                    .padding(start = 10.dp)
                    .border(
                        width = 0.5.dp, color = Color(0xFFC5C5C5),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 20.dp)
                    ),
                shape = RoundedCornerShape(size = 20.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                      currencyConversionViewModel.convertCurrency(currencyConversionViewModel.state.value.base,
                          currencyConversionViewModel.state.value.base ,
                          currencyConversionViewModel.state.value.amount)
            },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape)
        ) {
            Text(
                text = "Convert",
                style = TextStyle(
                    fontSize = 16.sp,
                    // fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(700),
                    color = Color.White,
                )
            )

        }


    }

}