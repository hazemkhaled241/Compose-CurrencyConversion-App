package com.hazem.currencyconversionapp.presentation.currency_conversion

import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails

data class FavoritesDetailsState(
    val error: String = "",
    val favorites: List<CurrencyDetails> = emptyList(),
    val isLoading: Boolean = false,
)
