package com.hazem.currencyconversionapp.presentation.currency_conversion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.domain.use_case.remote.ConvertCurrencyUseCase
import com.hazem.currencyconversionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConversionViewModel @Inject constructor(
    private val currencyUseCase: ConvertCurrencyUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CurrencyConversionState())
    val state: State<CurrencyConversionState> = _state

    init {
        convertCurrency("USD","EGP")
    }

    private fun convertCurrency(
        base: String,
        target: String
    ) {
        viewModelScope.launch {
            _state.value = CurrencyConversionState(isLoading = true)
            currencyUseCase(base = base, target = target).let { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = CurrencyConversionState(isLoading = false)
                        _state.value = CurrencyConversionState(error = result.message)
                    }

                    is Resource.Success -> {
                        _state.value = CurrencyConversionState(isLoading = false)
                        _state.value = CurrencyConversionState(value = result.data)

                    }
                }
            }
        }

    }
}