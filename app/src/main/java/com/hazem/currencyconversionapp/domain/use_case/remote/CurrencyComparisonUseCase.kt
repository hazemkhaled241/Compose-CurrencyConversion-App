package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.domain.model.remote.ComparisonResponse
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class CurrencyComparisonUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(
        base: String,
        firstTarget: String,
        secondTarget: String,
        amount: String
    ): Resource<ComparisonResponse, String> {
        return if (amount.isNotEmpty()) {
            currencyRepository.convertCurrencyWithTwoTarget(
                base = base,
                firstTarget = firstTarget,
                secondTarget = secondTarget,
                amount = amount
            )
        } else {
            Resource.Error("Amount can not be empty")
        }
    }
}