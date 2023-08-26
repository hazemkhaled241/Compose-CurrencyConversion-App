package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.domain.model.remote.Currency
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(): Resource<List<Currency>, String> {
        return currencyRepository.getCurrencies()
    }
}