package com.hazem.currencyconversionapp.presentation.currencies


data class DeleteCurrencyState(
    val error: String = "",
    val deletedSuccessfully: String = "",
    val isLoading: Boolean = false,
)
