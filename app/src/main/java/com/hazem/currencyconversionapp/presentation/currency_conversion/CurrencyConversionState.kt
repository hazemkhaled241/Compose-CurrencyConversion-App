package com.hazem.currencyconversionapp.presentation.currency_conversion

data class CurrencyConversionState(
    val error: String = "",
    val value:Double=0.0,
    val isLoading:Boolean=false,
    var paintrBase : String = "",
    var base : String = "",
    var paintrTarget : String = "",
    var target: String = "",
)
