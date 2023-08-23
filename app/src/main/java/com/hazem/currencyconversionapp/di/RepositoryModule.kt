package com.hazem.currencyconversionapp.di

import com.hazem.currencyconversionapp.data.remote.CurrencyApi
import com.hazem.currencyconversionapp.data.repository.CurrencyRepositoryImp
import com.hazem.currencyconversionapp.domain.repository.CurrencyRepository
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
}