package com.hazem.currencyconversionapp.di

import com.hazem.currencyconversionapp.data.remote.CurrencyApi
import com.hazem.currencyconversionapp.utils.Constants.CURRENCY_CONVERSION_API_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideCurrencyApi(): CurrencyApi {
        return Retrofit.Builder().baseUrl(CURRENCY_CONVERSION_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CurrencyApi::class.java)
    }
}