package com.hazem.currencyconversionapp.presentation.currencies

import com.hazem.currencyconversionapp.domain.model.Currency

data class CurrencyState(
    val error: String = "",
    val value: List<Currency> = emptyList(),
    val isLoading: Boolean = false
)
