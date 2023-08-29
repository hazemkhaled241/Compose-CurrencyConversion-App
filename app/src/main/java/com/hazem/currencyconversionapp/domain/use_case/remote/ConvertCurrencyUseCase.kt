package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class ConvertCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(
        base: String,
        target: String,
        amount: String
    ): Resource<Double, String> {
        return   if(amount.isNotEmpty()){
         currencyRepository.convertCurrency(base = base, target = target, amount = amount)
    } else {
            Resource.Error("Amount can not be empty")
        }
    }
}