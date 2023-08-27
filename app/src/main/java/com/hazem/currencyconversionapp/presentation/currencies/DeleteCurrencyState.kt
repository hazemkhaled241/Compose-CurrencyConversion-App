package com.hazem.currencyconversionapp.presentation.currencies

import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails

data class DeleteCurrencyState(
    val error: String = "",
    val favorites: List<CurrencyDetails> = emptyList(),
    val isLoading: Boolean = false,
)
