package com.hazem.currencyconversionapp.presentation.main_component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.currencyconversionapp.presentation.ui.theme.DarkWhite

@Composable
fun ConvertAndCompareToggle(
    /* currencyConversionViewModel: CurrencyConversionViewModel = hiltViewModel(),
     currencyComparisonViewModel: CurrencyComparisonViewModel = hiltViewModel()*/
    onConvertClicked: () -> Unit,
    onCompareClicked: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            20.dp,
            Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .width(274.dp)
            .border(width = 2.dp, shape = RoundedCornerShape(25.dp), color = DarkWhite)
    ) {


        Button(
            onClick = {
                onConvertClicked()
            }, colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Convert",
                style = TextStyle(
                    fontSize = 14.sp,
                    //  fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            )
        }
        Button(
            onClick = {
                onCompareClicked()
            }, colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Compare",
                style = TextStyle(
                    fontSize = 14.sp,
                    //  fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            )
        }
    }
}