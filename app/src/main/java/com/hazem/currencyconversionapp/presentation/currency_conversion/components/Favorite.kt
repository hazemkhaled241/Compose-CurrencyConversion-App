package com.hazem.currencyconversionapp.presentation.currency_conversion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.currencyconversionapp.presentation.ui.theme.DarkWhite

@Preview(showBackground = true)
@Composable
fun Favorite() {
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { /*TODO*/ },
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
            FavoriteItem(
                imageUrl = "https://www.countryflagicons.com/FLAT/64/US.png",
                currency = "USD",
                selected = false
            ) {}
            FavoriteItem(
                imageUrl = "https://www.countryflagicons.com/FLAT/64/US.png",
                currency = "USD",
                selected = false
            ) {}
            FavoriteItem(
                imageUrl = "https://www.countryflagicons.com/FLAT/64/US.png",
                currency = "USD",
                selected = false
            ) {}

            FavoriteItem(
                imageUrl = "https://www.countryflagicons.com/FLAT/64/US.png",
                currency = "USD",
                selected = false
            ) {}
        }
    }

}




