package com.hazem.currencyconversionapp.domain.use_case

import com.hazem.currencyconversionapp.domain.model.Currency
import com.hazem.currencyconversionapp.domain.repository.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(): Resource<List<Currency>, String> {
        return currencyRepository.getCurrencies()
    }
}