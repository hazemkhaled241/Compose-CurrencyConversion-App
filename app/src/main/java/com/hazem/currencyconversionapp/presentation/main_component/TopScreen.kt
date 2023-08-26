package com.hazem.currencyconversionapp.presentation.main_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.currencyconversionapp.R


@Composable
fun TopOfScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .paint(
                painter = painterResource(id = R.drawable.background_name),
                contentScale = ContentScale.FillBounds,
                alpha = 0.9f
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_name),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 20.dp, top = 50.dp)
                .width(142.dp)
                .height(32.dp)
        )
        Spacer(modifier = Modifier.height(80.dp))
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Currency Converter",
                style = TextStyle(
                    fontSize = 22.sp,
                    //  fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                    color = Color.White,
                )
            )

            Text(
                text = "Check live foreign currency exchange rates",
                style = TextStyle(
                    fontSize = 12.78.sp,
                    //  fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(400),
                    color = Color.White,
                )
            )
        }

    }
}