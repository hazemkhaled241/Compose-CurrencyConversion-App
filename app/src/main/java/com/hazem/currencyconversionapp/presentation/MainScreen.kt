package com.hazem.currencyconversionapp.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hazem.currencyconversionapp.presentation.currency_comparison.Comparison
import com.hazem.currencyconversionapp.presentation.currency_conversion.components.Conversion
import com.hazem.currencyconversionapp.presentation.main_component.ConvertAndCompareToggle
import com.hazem.currencyconversionapp.presentation.main_component.TopOfScreen

@Composable
fun MainScreen(
) {

    var isConvertClicked by remember {
        mutableStateOf(true)
    }
    var isCompareClicked by remember {
        mutableStateOf(false)
    }
    ConstraintLayout {
        val (topScreen, toggleButton, converterCard) = createRefs()
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
            },

                onConvertClicked = {
                    isConvertClicked = true
                    isCompareClicked = false
                })
        }

        Box(
            modifier = Modifier
                .constrainAs(converterCard) {
                    top.linkTo(topScreen.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            AnimatedVisibility(
                visible = isConvertClicked
            ) {
                Conversion()
            }

            AnimatedVisibility(
                visible = isCompareClicked
            ) {
                Comparison()

            }
        }
    }
}

