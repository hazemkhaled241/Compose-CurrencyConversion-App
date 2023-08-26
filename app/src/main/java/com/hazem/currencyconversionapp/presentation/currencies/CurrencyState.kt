package com.hazem.currencyconversionapp.presentation.currencies

import com.hazem.currencyconversionapp.domain.model.remote.Currency

data class CurrencyState(
    val error: String = "",
    val listCurrency: List<Currency> = emptyList(),
    val isLoading: Boolean = false,
   var ischeckBoxSelected : Boolean = false
)


