package com.hazem.currencyconversionapp.domain.repository

import com.hazem.currencyconversionapp.utils.Resource

interface CurrencyRepository {
    suspend fun convertCurrency(
        base: String,
        target: String
    ): Resource<Int, String>
}