package com.hazem.currencyconversionapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApi {
    @GET("/pair/{base}/{target}")
    suspend fun convertCurrency(@Path("base") base: String, @Path("target") target: String)
}