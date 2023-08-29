package com.hazem.currencyconversionapp.presentation.currency_comparison

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import com.hazem.currencyconversionapp.presentation.main_component.Currencies
import com.hazem.currencyconversionapp.presentation.main_component.CurrencyMenu
import com.hazem.currencyconversionapp.presentation.ui.theme.DarkWhite
import java.text.DecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Comparison(
    currencyComparisonViewModel: CurrencyComparisonViewModel = hiltViewModel(),
) {
    val dec = DecimalFormat("#,###.###")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 50.dp)
    ) {
        Row {
            Text(
                text = "Amount",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ), modifier = Modifier.weight(1f)
            )
            Text(
                text = "From",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ), modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        Row {
            OutlinedTextField(
                value = currencyComparisonViewModel.enteringAmount.value,
                onValueChange = {
                    currencyComparisonViewModel.setAmountState(it)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(size = 25.dp),
                modifier = Modifier
                    .padding(end = 15.dp)
                    .border(
                        width = 0.5.dp,
                        color = DarkWhite,
                        shape = RoundedCornerShape(size = 25.dp)
                    )
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 25.dp)
                    )
            )
            CurrencyMenu(
                currency = Currencies(
                    currencyComparisonViewModel.currencyBase,
                    currencyComparisonViewModel.painterBase
                ),
                onItemClicked = { base , painter->
                    currencyComparisonViewModel.currencyBase = base
                    currencyComparisonViewModel.painterBase = painter
                }, modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(20.dp),
                        color = DarkWhite
                    )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Text(
                text = "Targeted currency",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ), modifier = Modifier.weight(1f)
            )
            Text(
                text = "Targeted currency",
                style = TextStyle(
                    fontSize = 14.sp,
                    // fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ), modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            CurrencyMenu(
                currency = Currencies(
                    currencyComparisonViewModel.currencyFirstTarget,
                    currencyComparisonViewModel.painterFirstTarget
                ),
                onItemClicked = { firstTarget  , painter->
                    currencyComparisonViewModel.currencyFirstTarget = firstTarget
                    currencyComparisonViewModel.painterFirstTarget = painter
                }, modifier = Modifier
                    .padding(end = 15.dp)
                    .weight(1f)
                    .height(52.dp)
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(20.dp),
                        color = DarkWhite
                    )
            )

            CurrencyMenu(
                currency = Currencies(
                    currencyComparisonViewModel.currencySecondTarget,
                    currencyComparisonViewModel.painterSecondTarget
                ),
                onItemClicked = { secondTarget , painter ->
                    currencyComparisonViewModel.currencySecondTarget = secondTarget
                    currencyComparisonViewModel.painterSecondTarget = painter
                }, modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(20.dp),
                        color = DarkWhite
                    )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            OutlinedTextField(
                value = dec.format(currencyComparisonViewModel.state.value.value.
                firstConversionValue).toString(),
                onValueChange = {},
                readOnly = true,

                modifier = Modifier
                    .padding(end = 15.dp)
                    .weight(1f)
                    .border(
                        width = 0.5.dp, color = Color(0xFFC5C5C5),
                        shape = RoundedCornerShape(size = 25.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 25.dp)
                    ),
                shape = RoundedCornerShape(size = 25.dp)
            )
            OutlinedTextField(
                value = dec.format(currencyComparisonViewModel.state.value.value.
                secondConversionValue).toString(),
                onValueChange = {},
                readOnly = true,

                modifier = Modifier
                    .weight(1f)
                    .border(
                        width = 0.5.dp, color = Color(0xFFC5C5C5),
                        shape = RoundedCornerShape(size = 25.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 25.dp)
                    ),
                shape = RoundedCornerShape(size = 25.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                currencyComparisonViewModel.compare(
                    currencyComparisonViewModel.currencyBase,
                    currencyComparisonViewModel.currencyFirstTarget,
                    currencyComparisonViewModel.currencySecondTarget,
                    currencyComparisonViewModel.enteringAmount.value
                )
            },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp)
                .clip(CircleShape)
        ) {
            Text(
                text = "Compare",
                style = TextStyle(
                    fontSize = 16.sp,
                    // fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(700),
                    color = Color.White,
                )
            )
        }
        Divider()
    }
}








