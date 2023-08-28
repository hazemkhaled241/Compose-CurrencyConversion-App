package com.hazem.currencyconversionapp.data.repository.local

import com.hazem.currencyconversionapp.currenciesList
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.domain.repository.local.FavoriteCurrenciesRepository
import com.hazem.currencyconversionapp.utils.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FavoriteCurrenciesRepositoryTest {
    private lateinit var currencyDao: FakeCurrencyDao
    private lateinit var repo: FavoriteCurrenciesRepository

    @Before
    fun setUp() {
        currencyDao = FakeCurrencyDao()
        repo = FavoriteCurrenciesRepositoryImp(currencyDao)
    }

    @Test
    fun `add currency to favorite inserts currency entity`() = runBlocking {
        // Given
        val currency =
            CurrencyEntity(1, "USD")
        // When
        repo.addToFavorite(currency)

        // Then
        assert(
            currencyDao.getFavCurrencies().contains(currency)
        )
    }

    @Test
    fun `delete currency from favorites deletes currency entity`() = runBlocking {
        // Given
        val currency =
            CurrencyEntity(1, "USD")
        repo.addToFavorite(currency)

        // When
        repo.deleteFromFavorites(currency)

        // Then
        assert(
            currencyDao.getFavCurrencies().isEmpty()
        )

    }

    @Test
    fun `get favorite currencies returns list of currencies`() = runBlocking {
        // Given
        val currencies = currenciesList
        repo.addToFavorite(currencies.first())
        repo.addToFavorite(currencies.last())
        val expected =Resource.Success(currencies)

        // When
        val actual = repo.getAllFavoriteCurrencies()
        //then
        assertEquals(expected, actual)

    }
}