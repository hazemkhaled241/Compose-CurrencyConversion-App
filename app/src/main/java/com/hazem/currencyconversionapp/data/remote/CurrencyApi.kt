package com.hazem.currencyconversionapp.data.remote

import com.hazem.currencyconversionapp.data.remote.dto.ConversionResponseDto
import com.hazem.currencyconversionapp.data.remote.dto.ComparisonResponseDto
import com.hazem.currencyconversionapp.data.remote.dto.FavoritesDto
import com.hazem.currencyconversionapp.domain.model.remote.Currency
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {
    @GET("pair/{base}/{target}/{amount}")
    suspend fun convertCurrency(
        @Path("base") base: String,
        @Path("target") target: String,
        @Path("amount") amount: String
    ): ConversionResponseDto

    @GET("compare/{base}/{firstTarget}/{secondTarget}/{amount}")
    suspend fun compare(
        @Path("base") base: String,
        @Path("firstTarget") firstTarget: String,
        @Path("secondTarget") secondTarget: String,
        @Path("amount") amount: String
    ): ComparisonResponseDto

    @GET("images")
    suspend fun getCurrencies(): List<Currency>

    @GET("rates")
    suspend fun getRatesOfFavorites(
        @Query("baseCode") base: String ,
        @Query("targets") targets: List<String>,
    ): FavoritesDto
}