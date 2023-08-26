package com.hazem.currencyconversionapp.presentation.currency_conversion

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.domain.use_case.remote.ConvertCurrencyUseCase
import com.hazem.currencyconversionapp.domain.use_case.remote.GetAllFavoritesUseCase
import com.hazem.currencyconversionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConversionViewModel @Inject constructor(
    private val currencyUseCase: ConvertCurrencyUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CurrencyConversionState())
    val state: State<CurrencyConversionState> = _state

    private val _currencyDetailsState = mutableStateOf(FavoritesDetailsState())
    val currencyDetailsState: State<FavoritesDetailsState> = _currencyDetailsState

    private val _amountState = mutableDoubleStateOf(0.0)
    var amountState: State<Double> = _amountState

    init {
      //  convertCurrency("USD", "EUR", "10")
        getFavoritesDetails("USD", listOf("EUR","QAR"))
    }

    private fun convertCurrency(
        base: String,
        target: String,
        amount: String
    ) {
        viewModelScope.launch {
            _state.value = CurrencyConversionState(isLoading = true)
            currencyUseCase(base = base, target = target, amount = amount).let { result ->
                when (result) {
                    is Resource.Error -> {
                        Log.d("hhh", result.message)
                        _state.value = CurrencyConversionState(isLoading = false)
                        _state.value = CurrencyConversionState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d("hhh", result.data.toString())
                        _state.value = CurrencyConversionState(isLoading = false)
                        _state.value = CurrencyConversionState(value = result.data)

                    }
                }
            }
        }

    }

    private fun getFavoritesDetails(
        base: String,
        favorites: List<String>,
    ) {
        viewModelScope.launch {
            _currencyDetailsState.value = FavoritesDetailsState(isLoading = true)
            getAllFavoritesUseCase(base = base, favorites = favorites).let { result ->
                when (result) {
                    is Resource.Error -> {
                        Log.d("hhh", result.message)
                        _currencyDetailsState.value = FavoritesDetailsState(isLoading = false)
                        _currencyDetailsState.value = FavoritesDetailsState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d("hhh", result.data.toString())
                        _currencyDetailsState.value = FavoritesDetailsState(isLoading = false)
                        _currencyDetailsState.value = FavoritesDetailsState(favorites = result.data)

                    }
                }
            }
        }

    }

    fun setAmountState(amount: String) {
        _amountState.doubleValue = amount.toDouble()
    }
}