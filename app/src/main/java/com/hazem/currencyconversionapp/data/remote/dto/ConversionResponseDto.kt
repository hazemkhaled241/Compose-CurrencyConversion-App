package com.hazem.currencyconversionapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ConversionResponseDto(

    @SerializedName("conversionRate")
    val conversionRate: String,
    @SerializedName("conversionValue")
    val conversionValue: String
)
