package com.hazem.currencyconversionapp.data.repository

import com.hazem.currencyconversionapp.data.remote.CurrencyApi
import com.hazem.currencyconversionapp.domain.model.ComparisonResponse
import com.hazem.currencyconversionapp.domain.model.Currency
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
    ): Resource<Double, String> {
        return try {
            Resource.Success(
                api.convertCurrency(
                    base = base,
                    target = target
                ).conversionRate.toDouble()
            )
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }

    override suspend fun convertCurrencyWithTwoTarget(
        base: String,
        firstTarget: String,
        secondTarget: String
    ): Resource<ComparisonResponse, String> {
        return try {
            val response = api.compare(
                base = base,
                firstTarget = firstTarget,
                secondTarget = secondTarget
            )
            Resource.Success(
                ComparisonResponse(
                    firstConversionRate = response.firstConversionRate.toDouble(),
                    secondConversionRate = response.secondConversionRate.toDouble()
                )
            )
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }

    override suspend fun getCurrencies(): Resource<List<Currency>, String> {
        return try {
            Resource.Success(api.getCurrencies())
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }
}