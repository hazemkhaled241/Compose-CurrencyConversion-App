package com.hazem.currencyconversionapp.data.remote

import com.hazem.currencyconversionapp.data.remote.dto.ConversionResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApi {
    @GET("/pair/{base}/{target}")
    suspend fun convertCurrency(@Path("base") base: String, @Path("target") target: String):ConversionResponseDto
}