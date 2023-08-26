package com.hazem.currencyconversionapp.domain.use_case.remote

import com.hazem.currencyconversionapp.domain.model.remote.CurrencyDetails
import com.hazem.currencyconversionapp.domain.repository.remote.CurrencyRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke(
        base: String,
        favorites: List<String>
    ): Resource<List<CurrencyDetails>, String> {
        return currencyRepository.getRatesOfFavorites(base = base, favorites = favorites)
    }
}