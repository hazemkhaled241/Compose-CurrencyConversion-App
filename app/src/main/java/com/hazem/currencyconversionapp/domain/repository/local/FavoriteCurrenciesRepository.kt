package com.hazem.currencyconversionapp.domain.repository.local

import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.utils.Resource

interface FavoriteCurrenciesRepository {
    suspend fun addToFavorite(fav: CurrencyEntity):Resource<String,String>
    suspend fun getAllFavoriteCurrencies(): Resource<List<CurrencyEntity>, String>
    suspend fun deleteFromFavorites(currency: CurrencyEntity): Resource<String, String>
}