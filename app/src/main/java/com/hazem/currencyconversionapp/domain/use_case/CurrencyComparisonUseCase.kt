package com.hazem.currencyconversionapp.domain.use_case

import com.hazem.currencyconversionapp.domain.model.ComparisonResponse
import com.hazem.currencyconversionapp.domain.repository.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class CurrencyComparisonUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(
        base: String,
        firstTarget: String,
        secondTarget: String
    ): Resource<ComparisonResponse, String> {
        return currencyRepository.convertCurrencyWithTwoTarget(
            base = base,
            firstTarget = firstTarget,
            secondTarget = secondTarget
        )
    }
}