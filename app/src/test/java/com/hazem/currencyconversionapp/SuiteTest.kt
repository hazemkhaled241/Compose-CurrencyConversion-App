package com.hazem.currencyconversionapp

import com.hazem.currencyconversionapp.data.repository.local.FavoriteCurrenciesRepositoryTest
import com.hazem.currencyconversionapp.data.repository.remote.CurrencyRepositoryTest
import com.hazem.currencyconversionapp.domain.use_case.local.AddCurrencyToFavoriteUseCaseTest
import com.hazem.currencyconversionapp.domain.use_case.local.DeleteFromFavoritesUseCaseTest
import com.hazem.currencyconversionapp.domain.use_case.local.GetAllFavoriteCurrenciesUseCaseTest
import com.hazem.currencyconversionapp.domain.use_case.remote.ConvertCurrencyUseCaseTest
import com.hazem.currencyconversionapp.domain.use_case.remote.CurrencyComparisonUseCaseTest
import com.hazem.currencyconversionapp.domain.use_case.remote.GetAllFavoritesUseCaseTest
import com.hazem.currencyconversionapp.domain.use_case.remote.GetCurrenciesUseCaseTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AddCurrencyToFavoriteUseCaseTest::class,
    DeleteFromFavoritesUseCaseTest::class,
    GetAllFavoriteCurrenciesUseCaseTest::class,
    ConvertCurrencyUseCaseTest::class,
    CurrencyComparisonUseCaseTest::class,
    GetAllFavoritesUseCaseTest::class,
    GetCurrenciesUseCaseTest::class,
    CurrencyRepositoryTest::class,
    FavoriteCurrenciesRepositoryTest::class,
)
class TestSuite