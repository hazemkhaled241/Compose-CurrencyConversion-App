package com.hazem.currencyconversionapp.data.repository

import com.hazem.currencyconversionapp.data.remote.CurrencyApi
import com.hazem.currencyconversionapp.domain.repository.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CurrencyRepositoryImp @Inject constructor(
    private val api: CurrencyApi
) : CurrencyRepository {
    override suspend fun convertCurrency(
        base: String,
        target: String
    ): Resource<Int, String> {
        return try {
            Resource.Success(api.convertCurrency(base = base, target = target).conversionRate.toInt())
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }
}