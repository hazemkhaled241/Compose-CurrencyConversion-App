package com.hazem.currencyconversionapp.domain.model.remote

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("flag")
    val flag: String
)
