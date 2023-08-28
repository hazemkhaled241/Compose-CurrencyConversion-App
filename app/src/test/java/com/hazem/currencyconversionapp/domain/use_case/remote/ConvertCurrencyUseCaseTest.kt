package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ConvertCurrencyUseCaseTest {
    private lateinit var useCase: ConvertCurrencyUseCase
    private val repository: CurrencyRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = ConvertCurrencyUseCase(repository)
    }

    @Test
    fun `test invoke() function with a Fake data`() = runBlocking {
        // Given
        coEvery {
            repository.convertCurrency("USD","EGP","1")
        } returns Resource.Success(30.8)

        // When
        useCase("USD","EGP","1")

        // Then
        coVerify { repository.convertCurrency("USD","EGP","1") }
    }
}