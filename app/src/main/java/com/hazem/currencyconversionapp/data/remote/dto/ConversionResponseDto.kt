package com.hazem.currencyconversionapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ConversionResponseDto(
    @SerializedName("base_code")
    val baseCode: String,
    @SerializedName("target_code")
    val targetCode: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("conversion_rate")
    val conversionRate: String,
    @SerializedName("conversion_value")
    val conversionValue: String
)
