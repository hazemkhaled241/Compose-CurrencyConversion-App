package com.hazem.currencyconversionapp.di

import com.hazem.currencyconversionapp.data.local.CurrencyDao
import com.hazem.currencyconversionapp.data.remote.CurrencyApi
import com.hazem.currencyconversionapp.data.repository.local.FavoriteCurrenciesRepositoryImp
import com.hazem.currencyconversionapp.data.repository.remote.CurrencyRepositoryImp
import com.hazem.currencyconversionapp.domain.repository.local.FavoriteCurrenciesRepository
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCurrencyRepository(currencyApi: CurrencyApi): CurrencyRepository {
        return CurrencyRepositoryImp(currencyApi)
    }

    @Provides
    @Singleton
    fun provideFavoriteCurrenciesRepository(currencyDao: CurrencyDao): FavoriteCurrenciesRepository {
        return FavoriteCurrenciesRepositoryImp(currencyDao)
    }
}