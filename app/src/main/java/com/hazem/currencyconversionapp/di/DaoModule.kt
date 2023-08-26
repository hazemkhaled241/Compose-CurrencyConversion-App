package com.hazem.currencyconversionapp.di

import android.content.Context
import com.hazem.currencyconversionapp.data.local.CurrencyDao
import com.hazem.currencyconversionapp.data.local.CurrencyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideDao(@ApplicationContext context: Context): CurrencyDao {
        return CurrencyDataBase.getDataBase(context).currencyDao()
    }
}