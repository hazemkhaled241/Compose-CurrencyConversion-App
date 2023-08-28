package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.domain.model.remote.ComparisonResponse
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CurrencyComparisonUseCaseTest {
    private lateinit var useCase: CurrencyComparisonUseCase
    private val repository: CurrencyRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = CurrencyComparisonUseCase(repository)
    }

    @Test
    fun `test invoke() function with a Fake data`() = runBlocking {
        // Given
        coEvery {
            repository.convertCurrencyWithTwoTarget("USD","EGP","SAR","1")
        } returns Resource.Success(ComparisonResponse(30.8,3.75))

        // When
        useCase("USD","EGP","SAR","1")

        // Then
        coVerify { repository.convertCurrencyWithTwoTarget("USD","EGP","SAR","1") }
    }
}