package com.hazem.currencyconversionapp.presentation.currency_conversion

import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity

data class GetAllFavoriteCurrencyState(
    val error: String = "",
    val isLoading: Boolean = false,
    val allCurrency : List<CurrencyEntity> = emptyList(),
)

