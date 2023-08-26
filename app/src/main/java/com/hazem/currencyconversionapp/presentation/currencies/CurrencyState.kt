package com.hazem.currencyconversionapp.presentation.currencies

import com.hazem.currencyconversionapp.domain.model.remote.Currency

data class CurrencyState(
    val error: String = "",
    val currencyList: List<Currency> = emptyList(),
    val isLoading: Boolean = false
)


