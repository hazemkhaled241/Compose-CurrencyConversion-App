package com.hazem.currencyconversionapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails

data class FavoritesDto(
    @SerializedName("baseCurrency") var baseCurrency: String,
    @SerializedName("targets") var targets: List<CurrencyDetails>
)
