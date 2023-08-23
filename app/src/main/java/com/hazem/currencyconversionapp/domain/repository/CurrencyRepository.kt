package com.hazem.currencyconversionapp.domain.repository

import com.hazem.currencyconversionapp.domain.model.ComparisonResponse
import com.hazem.currencyconversionapp.domain.model.Currency
import com.hazem.currencyconversionapp.utils.Resource

interface CurrencyRepository {
    suspend fun convertCurrency(
        base: String,
        target: String
    ): Resource<Double, String>

    suspend fun convertCurrencyWithTwoTarget(
        base: String,
        firstTarget: String,
        secondTarget: String
    ): Resource<ComparisonResponse, String>

    suspend fun getCurrencies(): Resource<List<Currency>, String>
}