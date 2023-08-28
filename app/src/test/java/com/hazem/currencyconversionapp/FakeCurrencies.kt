package com.hazem.currencyconversionapp

import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.domain.model.remote.Currency
import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails

val currencies = listOf(
    Currency("USD",""),
    Currency("EGP","")
)
val currenciesDetails= listOf(
    CurrencyDetails("USD","1",""),
    CurrencyDetails("EGP","30.8",""),
)

val currenciesList = listOf(
    CurrencyEntity(1,"USD"),
    CurrencyEntity(2,"EGP")
)