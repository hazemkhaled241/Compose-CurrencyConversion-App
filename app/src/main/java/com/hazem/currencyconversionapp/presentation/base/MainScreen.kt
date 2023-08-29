package com.hazem.currencyconversionapp.presentation.base

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hazem.currencyconversionapp.presentation.currency_comparison.Comparison
import com.hazem.currencyconversionapp.presentation.currency_conversion.CurrencyConversionViewModel
import com.hazem.currencyconversionapp.presentation.currency_conversion.CurrencyEvents
import com.hazem.currencyconversionapp.presentation.currency_conversion.components.Conversion
import com.hazem.currencyconversionapp.presentation.main_component.ConvertAndCompareToggle
import com.hazem.currencyconversionapp.presentation.main_component.Portfolio
import com.hazem.currencyconversionapp.presentation.main_component.TopOfScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    currencyConversionViewModel: CurrencyConversionViewModel = hiltViewModel(),
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {

    currencyConversionViewModel.onEvent(CurrencyEvents.GetAllFavoriteCurrencies)
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val favList = currencyConversionViewModel.getAllFavoriteCurrencyState.value.allCurrency
    val favoriteList = favList.map { it.currency }
    if (!currencyConversionViewModel.getAllFavoriteCurrencyState.value.isLoading) {
        LaunchedEffect(key1 = currencyConversionViewModel.currencyBase) {
            Log.d("kkk", favoriteList.toString())

            currencyConversionViewModel.onEvent(
                CurrencyEvents.GetFavoritesDetails(
                    base = currencyConversionViewModel.currencyBase,
                    currencies = favoriteList
                )
            )
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { padding ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            val liveExchangeList = currencyConversionViewModel.currencyDetailsState.value.favorites

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

                        TopOfScreen(pageName = mainViewModel.pageNameState)
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(toggleButton) {
                                top.linkTo(parent.top, margin = 280.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        ConvertAndCompareToggle()
                    }

                    Box(modifier = Modifier
                        .constrainAs(converterCard) {
                            top.linkTo(topScreen.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {

                        androidx.compose.animation.AnimatedVisibility(
                            visible = mainViewModel.isConvertClickedState.value
                        ) {
                            Conversion()
                        }

                        androidx.compose.animation.AnimatedVisibility(
                            visible = mainViewModel.isCompareClickedState.value
                        ) {

                            Comparison()
                        }
                    }
                    Box(modifier = Modifier
                        .constrainAs(portfolio) {
                            top.linkTo(converterCard.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }) {
                        if (!currencyConversionViewModel.currencyDetailsState.value.isLoading) {
                            Portfolio(navController = navController, list = liveExchangeList)
                        }
                    }


                }
            }
            if (currencyConversionViewModel.currencyDetailsState.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Blue
                )
            }
        }
        LaunchedEffect(key1 = currencyConversionViewModel.currencyDetailsState.value.error) {
            if (currencyConversionViewModel.currencyDetailsState.value.error.isNotEmpty()) {
                scope.launch {
                    snackBarHostState.showSnackbar(
                        currencyConversionViewModel.currencyDetailsState.value.error
                    )
                }
            }
        }

        LaunchedEffect(key1 = currencyConversionViewModel.state.value.error) {
            if (currencyConversionViewModel.state.value.error.isNotEmpty()) {
                scope.launch {
                    snackBarHostState.showSnackbar(
                        currencyConversionViewModel.state.value.error
                    )
                }
            }
        }
    }
}