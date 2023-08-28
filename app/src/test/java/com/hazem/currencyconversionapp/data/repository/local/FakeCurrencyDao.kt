package com.hazem.currencyconversionapp.data.repository.local

import com.hazem.currencyconversionapp.data.local.CurrencyDao
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity

class FakeCurrencyDao:CurrencyDao {
    private val currenciesList = arrayListOf<CurrencyEntity>()
    override suspend fun getFavCurrencies(): List<CurrencyEntity> {
       return currenciesList
    }

    override suspend fun addToFavorite(fav: CurrencyEntity) {
        currenciesList.add(fav)
    }

    override suspend fun deleteFromFavorites(currency: CurrencyEntity) {
        currenciesList.remove(currency)
    }
}