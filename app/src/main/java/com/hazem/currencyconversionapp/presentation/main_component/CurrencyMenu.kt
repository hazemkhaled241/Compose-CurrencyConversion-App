package com.hazem.currencyconversionapp.presentation.main_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.hazem.currencyconversionapp.presentation.currencies.CurrenciesViewModel
import com.hazem.currencyconversionapp.presentation.ui.theme.DarkWhite


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyMenu(
    currenciesViewModel: CurrenciesViewModel = hiltViewModel(),
    currency: Currencies,
    onItemClicked: (String) -> Unit,
    modifier: Modifier
) {

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    var isMenuExpanded by remember {
        mutableStateOf(false)
    }
    ExposedDropdownMenuBox(expanded = isMenuExpanded, onExpandedChange = {
        isMenuExpanded = it
    }, modifier = modifier) {

        Box(modifier = Modifier
            .fillMaxSize()
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(20.dp),
                color = DarkWhite
            )
            .onGloballyPositioned { coordinates ->
                textFieldSize = coordinates.size.toSize()
            }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .menuAnchor(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val painter =
                    rememberAsyncImagePainter(model = currency.flag)
                Image(
                    painter = painter, contentDescription = "flag",
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = currency.currency)
            }

            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                onClick = { isMenuExpanded = !isMenuExpanded },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isMenuExpanded)
            }
        }



        ExposedDropdownMenu(
            expanded = isMenuExpanded,
            onDismissRequest = { isMenuExpanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            repeat(currenciesViewModel.state.value.listCurrency.size) {
                DropdownMenuItem(text = {
                    val painter =
                        rememberAsyncImagePainter(model = currenciesViewModel.state.value.listCurrency[it].flag)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painter, contentDescription = "currency flag",
                            modifier = Modifier
                                .size(30.dp)
                                .background(
                                    color = Color.White,
                                    shape = CircleShape
                                ),
                        )
                        Text(text = currenciesViewModel.state.value.listCurrency[it].currency)

                    }
                },
                    onClick = {

                        currency.currency =
                            currenciesViewModel.state.value.listCurrency[it].currency
                        currency.flag =
                            currenciesViewModel.state.value.listCurrency[it].flag


                        onItemClicked(currenciesViewModel.state.value.listCurrency[it].currency)
                        isMenuExpanded = false

                    })
            }

        }

    }
}

data class Currencies(
    var currency: String,
    var flag: String
)