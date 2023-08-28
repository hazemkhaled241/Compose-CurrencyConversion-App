package com.hazem.currencyconversionapp.domain.use_case.local

import com.hazem.currencyconversionapp.currenciesList
import com.hazem.currencyconversionapp.domain.repository.local.FavoriteCurrenciesRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllFavoriteCurrenciesUseCaseTest {
    private lateinit var useCase: GetAllFavoriteCurrenciesUseCase
    private val repository: FavoriteCurrenciesRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = GetAllFavoriteCurrenciesUseCase(repository)
    }

    @Test
    fun `test invoke() function with a fake CurrencyEntity`() = runBlocking {
        // Given
        coEvery {
            repository.getAllFavoriteCurrencies()
        } returns Resource.Success(
          currenciesList
        )

        // When
        useCase()

        // Then
        coVerify { repository.getAllFavoriteCurrencies() }
    }
}