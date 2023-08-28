package com.hazem.currencyconversionapp.data.repository.remote

import com.hazem.currencyconversionapp.currencies
import com.hazem.currencyconversionapp.currenciesDetails
import com.hazem.currencyconversionapp.data.remote.CurrencyApi
import com.hazem.currencyconversionapp.data.remote.dto.ComparisonResponseDto
import com.hazem.currencyconversionapp.data.remote.dto.ConversionResponseDto
import com.hazem.currencyconversionapp.data.remote.dto.FavoritesDto
import com.hazem.currencyconversionapp.domain.model.remote.ComparisonResponse
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.IOException

class CurrencyRepositoryTest {
    private lateinit var currenciesApi: CurrencyApi
    private lateinit var repo: CurrencyRepository

    @Before
    fun setUp() {
        currenciesApi = mockk()
        repo = CurrencyRepositoryImp(api = currenciesApi)
    }

    @Test
    fun `getCurrencies returns success resource when API call is successful`() = runBlocking {
        // Given
        coEvery { currenciesApi.getCurrencies() } returns (
               currencies
                )
        val expected = Resource.Success(currencies)

        // When
        val actual = repo.getCurrencies()

        // Then
        assertEquals(expected, actual)
    }


    @Test
    fun `getCurrencies(),when there is an exception,then returns error resource with error message`() =
        runBlocking {
            // Given
            val expected = Resource.Error("Couldn't reach server. Check your internet connection.")
            coEvery { currenciesApi.getCurrencies() } throws IOException("Couldn't reach server. Check your internet connection.")

            // When
            val actual = repo.getCurrencies()

            // Then
            assertEquals(expected, actual)
        }

    @Test
    fun `convertCurrency returns success resource when API call is successful`() = runBlocking {
        // Given
        coEvery { currenciesApi.convertCurrency("USD","EGP","1") } returns (
                ConversionResponseDto("30.8","30.8")
                )
        val expected = Resource.Success(30.8)

        // When
        val actual = repo.convertCurrency("USD","EGP","1")

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `convertCurrencyWithTwoTarget returns success resource when API call is successful`() = runBlocking {
        // Given
        coEvery { currenciesApi.compare("USD","EGP","SAR","1") } returns (
                ComparisonResponseDto("30.8","3.75")
                )
        val expected = Resource.Success(ComparisonResponse(30.8,3.75))

        // When
        val actual = repo.convertCurrencyWithTwoTarget("USD","EGP","SAR","1")

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `getRatesOfFavorites returns success resource when API call is successful`() = runBlocking {
        // Given
        coEvery { currenciesApi.getRatesOfFavorites("USD", listOf("USD","EGP")) } returns (
                FavoritesDto("USD", currenciesDetails)
                )
        val expected = Resource.Success(currenciesDetails)

        // When
        val actual = repo.getRatesOfFavorites("USD", listOf("USD","EGP"))

        // Then
        assertEquals(expected, actual)
    }
}