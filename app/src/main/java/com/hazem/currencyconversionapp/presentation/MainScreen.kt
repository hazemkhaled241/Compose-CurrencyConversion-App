package com.hazem.currencyconversionapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.hazem.currencyconversionapp.presentation.currency_comparison.Comparison
import com.hazem.currencyconversionapp.presentation.currency_conversion.components.Conversion
import com.hazem.currencyconversionapp.presentation.main_component.ConvertAndCompareToggle
import com.hazem.currencyconversionapp.presentation.main_component.Portfolio
import com.hazem.currencyconversionapp.presentation.main_component.TopOfScreen

@Composable
fun MainScreen(
    navController: NavController
) {

    var isConvertClicked by remember {
        mutableStateOf(true)
    }
    var isCompareClicked by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ConstraintLayout {
            val (topScreen, toggleButton, converterCard, portfolio) = createRefs()
            Box(
                modifier = Modifier
                    .constrainAs(topScreen) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                TopOfScreen()
            }
            Box(
                modifier = Modifier
                    .constrainAs(toggleButton) {
                        top.linkTo(parent.top, margin = 280.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                ConvertAndCompareToggle(onCompareClicked = {
                    isConvertClicked = false
                    isCompareClicked = true

                }, onConvertClicked = {
                    isConvertClicked = true
                    isCompareClicked = false
                })
            }

            Box(modifier = Modifier
                .constrainAs(converterCard) {
                    top.linkTo(topScreen.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = isConvertClicked
                ) {
                    Conversion()
                }

                androidx.compose.animation.AnimatedVisibility(
                    visible = isCompareClicked
                ) {
                    Comparison()
                }
            }
            Box(modifier = Modifier
                .constrainAs(portfolio) {
                    top.linkTo(converterCard.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                Portfolio(navController = navController)
            }


        }
    }
}
