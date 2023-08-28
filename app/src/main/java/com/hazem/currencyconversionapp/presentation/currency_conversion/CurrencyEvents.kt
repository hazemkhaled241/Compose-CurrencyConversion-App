package com.hazem.currencyconversionapp.presentation.currency_conversion

import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity

sealed class CurrencyEvents{
    data class AddToFavorite(val currencyEntity: CurrencyEntity): CurrencyEvents()
    data class DeleteFromFavorites(val currencyEntity: CurrencyEntity): CurrencyEvents()
    data class GetFavoritesDetails(val currencies: List<String>,val base:String): CurrencyEvents()
    object GetAllFavoriteCurrencies: CurrencyEvents()
}
