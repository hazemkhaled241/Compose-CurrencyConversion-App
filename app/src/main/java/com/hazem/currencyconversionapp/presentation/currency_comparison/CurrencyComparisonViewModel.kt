package com.hazem.currencyconversionapp.presentation.currency_comparison

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.domain.use_case.CurrencyComparisonUseCase
import com.hazem.currencyconversionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyComparisonViewModel @Inject constructor(
    private val currencyComparisonUseCase: CurrencyComparisonUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CurrencyComparisonState())
    val state: State<CurrencyComparisonState> = _state

    init {
        compare("USD", "QAR","EUR")
    }

    private fun compare(
        base: String,
        firstTarget: String,
        secondTarget: String
    ) {
        viewModelScope.launch {
            _state.value = CurrencyComparisonState(isLoading = true)
            currencyComparisonUseCase(
                base = base,
                firstTarget = firstTarget,
                secondTarget = secondTarget
            ).let { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = CurrencyComparisonState(isLoading = false)
                        _state.value = CurrencyComparisonState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d("hhh", result.data.firstConversionRate.toString()  +"  "+result.data.secondConversionRate.toString())
                        _state.value = CurrencyComparisonState(isLoading = false)
                        _state.value = CurrencyComparisonState(value = result.data)

                    }
                }
            }
        }

    }
}