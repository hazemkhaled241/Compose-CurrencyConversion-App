package com.hazem.currencyconversionapp.domain.use_case.local

import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.domain.repository.local.FavoriteCurrenciesRepository
import com.hazem.currencyconversionapp.utils.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddCurrencyToFavoriteUseCaseTest {
    private lateinit var useCase: AddCurrencyToFavoriteUseCase
    private val repository: FavoriteCurrenciesRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = AddCurrencyToFavoriteUseCase(repository)
    }

    @Test
    fun `test invoke() function with a Fake CurrencyEntity`() = runBlocking {
        // Given
        coEvery {
            repository.addToFavorite(
                CurrencyEntity(
                    1,
                    ""
                )
            )
        } returns Resource.Success("Added successfully")

        // When
        useCase(CurrencyEntity(1, ""))

        // Then
        coVerify { repository.addToFavorite(CurrencyEntity(1, "")) }
    }
}