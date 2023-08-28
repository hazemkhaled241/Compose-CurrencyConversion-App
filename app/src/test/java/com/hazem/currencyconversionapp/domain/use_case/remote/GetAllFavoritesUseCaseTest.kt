package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.currenciesDetails
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllFavoritesUseCaseTest {
    private lateinit var useCase: GetAllFavoritesUseCase
    private val repository: CurrencyRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = GetAllFavoritesUseCase(repository)
    }

    @Test
    fun `test invoke() function with a Fake data`() = runBlocking {
        // Given
        coEvery {
            repository.getRatesOfFavorites("USD", listOf("USD","EGP"))
        } returns Resource.Success(currenciesDetails)

        // When
        useCase("USD", listOf("USD","EGP"))

        // Then
        coVerify { repository.getRatesOfFavorites("USD", listOf("USD","EGP")) }
    }
}