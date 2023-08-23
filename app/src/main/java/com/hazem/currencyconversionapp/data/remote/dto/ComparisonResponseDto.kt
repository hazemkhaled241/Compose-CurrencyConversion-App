package com.hazem.currencyconversionapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ComparisonResponseDto(
    @SerializedName("base_code")
    val baseCode: String,
    @SerializedName("first_target_code")
    val firstTargetCode: String,
    @SerializedName("second_target_code")
    val secondTargetCode: String,
    @SerializedName("first_Conversion_rate")
    val firstConversionRate: String,
    @SerializedName("second_Conversion_rate")
    val secondConversionRate: String
)
