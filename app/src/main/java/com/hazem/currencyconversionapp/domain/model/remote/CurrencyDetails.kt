package com.hazem.currencyconversionapp.domain.model.remote

import com.google.gson.annotations.SerializedName

data class CurrencyDetails(
    @SerializedName("currency") var currency: String,
    @SerializedName("exchange_rate") var exchangeRate: String,
    @SerializedName("flag") var flag: String
)
