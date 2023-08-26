package com.hazem.currencyconversionapp.presentation.currency_comparison

import com.hazem.currencyconversionapp.domain.model.remote.ComparisonResponse

data class CurrencyComparisonState(
    val error: String = "",
    val value: ComparisonResponse = ComparisonResponse(0.0, 0.0),
    val isLoading: Boolean = false,
    val amountState : Double =0.0,
    var painterBase: String = "",
    var painterFirstTarget: String = "",
    var painterSecondTarget: String = "",
    var base : String = "",
    var firstTarget : String = "",
    var secondTarget: String = "",
)
