package com.hazem.currencyconversionapp.presentation.currency_comparison

import com.hazem.currencyconversionapp.domain.model.remote.ComparisonResponse

data class CurrencyComparisonState(
    val error: String = "",
    val value: ComparisonResponse = ComparisonResponse(0.0, 0.0),
    val isLoading: Boolean = false
)
