package com.hazem.currencyconversionapp.domain.use_case

import com.hazem.currencyconversionapp.domain.repository.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class ConvertCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(
        base: String,
        target: String
    ): Resource<Int, String> {
        return currencyRepository.convertCurrency(base = base, target = target)
    }
}