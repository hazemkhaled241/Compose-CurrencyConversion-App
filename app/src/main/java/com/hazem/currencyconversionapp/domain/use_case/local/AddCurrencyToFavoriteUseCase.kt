package com.hazem.currencyconversionapp.domain.use_case.local

import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.domain.repository.local.FavoriteCurrenciesRepository
import com.hazem.currencyconversionapp.utils.Resource
import javax.inject.Inject

class AddCurrencyToFavoriteUseCase @Inject constructor(
    private val favoriteCurrenciesRepository: FavoriteCurrenciesRepository
) {
    suspend operator fun invoke(fav: CurrencyEntity):Resource<String,String> {
     return   favoriteCurrenciesRepository.addToFavorite(fav)
    }
}