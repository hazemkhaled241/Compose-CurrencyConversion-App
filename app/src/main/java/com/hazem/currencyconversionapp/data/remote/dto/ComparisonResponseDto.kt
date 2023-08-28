package com.hazem.currencyconversionapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ComparisonResponseDto(

    @SerializedName("firstConversionValue")
    val firstConversionValue: String,
    @SerializedName("secondConversionValue")
    val secondConversionValue: String
)
