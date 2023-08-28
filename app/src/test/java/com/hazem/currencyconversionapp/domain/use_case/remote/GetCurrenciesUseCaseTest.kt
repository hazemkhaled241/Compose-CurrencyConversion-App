package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.currencies
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCurrenciesUseCaseTest {
    private lateinit var useCase: GetCurrenciesUseCase
    private val repository: CurrencyRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = GetCurrenciesUseCase(repository)
    }

    @Test
    fun `test invoke() function with a Fake data`() = runBlocking {
        // Given
        coEvery {
            repository.getCurrencies()
        } returns Resource.Success(currencies)

        // When
        useCase()

        // Then
        coVerify { repository.getCurrencies() }
    }
}