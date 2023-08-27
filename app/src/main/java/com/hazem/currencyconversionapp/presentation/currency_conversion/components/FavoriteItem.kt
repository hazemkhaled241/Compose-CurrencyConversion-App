package com.hazem.currencyconversionapp.presentation.currency_conversion.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun FavoriteItem(
    imageUrl: String,
    currency: String,
    selected: Boolean,
    onChecked: (Boolean) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val painter = rememberAsyncImagePainter(model = imageUrl)
            Image(
                painter = painter, contentDescription = "currency flag",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 5.dp)
                    .clip(CircleShape)
                    .scale(1.5f)
                    .size(50.dp)
                //  .background(shape = CircleShape, color = Color.White)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = currency)
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "CURRENCY",
                    style = TextStyle(
                        fontSize = 11.56.sp,
                        lineHeight = 19.27.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(400),
                        color = Color.LightGray,
                    )
                )
            }
        }
        CircleCheckBox(
            selected = selected,
            modifier = Modifier.align(Alignment.CenterEnd),
            onChecked = { onChecked(!selected) }
        )
        Divider(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
