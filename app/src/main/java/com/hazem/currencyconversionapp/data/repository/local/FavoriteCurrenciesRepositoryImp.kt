package com.hazem.currencyconversionapp.data.repository.local

import com.hazem.currencyconversionapp.data.local.CurrencyDao
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.domain.repository.local.FavoriteCurrenciesRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class FavoriteCurrenciesRepositoryImp @Inject constructor(
    private val currencyDao: CurrencyDao
) : FavoriteCurrenciesRepository {
    override suspend fun addToFavorite(fav: CurrencyEntity): Resource<String, String> {
        return try {
            currencyDao.addToFavorite(fav)
            Resource.Success("Added Successfully")
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        }
    }

    override suspend fun getAllFavoriteCurrencies(): Resource<List<CurrencyEntity>, String> {
        return try {
            Resource.Success(currencyDao.getFavCurrencies())
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        }
    }

    override suspend fun deleteFromFavorites(currency: CurrencyEntity): Resource<String, String> {
        return try {
            currencyDao.deleteFromFavorites(currency)
            Resource.Success("Deleted Successfully")
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        }
    }
}