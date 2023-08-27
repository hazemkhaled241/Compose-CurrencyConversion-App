package com.hazem.currencyconversionapp.presentation.currencies


data class AddCurrencyState(
    val error: String = "",
    val addedSuccessfully: String = "",
    val isLoading: Boolean = false,
)

