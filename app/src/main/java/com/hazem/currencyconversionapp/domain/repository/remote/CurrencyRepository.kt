package com.hazem.currencyconversionapp.domain.repository.remote

import com.hazem.currencyconversionapp.domain.model.remote.ComparisonResponse
import com.hazem.currencyconversionapp.domain.model.remote.Currency
import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails
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
    suspend fun getRatesOfFavorites(
        base: String,
        favorites: List<String>
    ): Resource<List<CurrencyDetails>, String>
}