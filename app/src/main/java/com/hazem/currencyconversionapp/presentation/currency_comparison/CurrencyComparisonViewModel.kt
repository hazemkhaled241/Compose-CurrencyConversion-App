package com.hazem.currencyconversionapp.presentation.currency_comparison

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.domain.use_case.remote.CurrencyComparisonUseCase
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


    private val _currencyBase = mutableStateOf("")
    var currencyBase: String = _currencyBase.value

    private val _currencyFirstTarget = mutableStateOf("")
    var currencyFirstTarget: String = _currencyFirstTarget.value

    private val _currencySecondTarget = mutableStateOf("")
    var currencySecondTarget: String = _currencySecondTarget.value

    private val _painterBase = mutableStateOf("")
    var painterBase: String= _painterBase.value

    private val _painterFirstTarget = mutableStateOf("")
    var painterFirstTarget: String = _painterFirstTarget.value
    private val _painterSecondTarget = mutableStateOf("")
    var painterSecondTarget: String = _painterSecondTarget.value

    var enteringAmount = mutableStateOf("")



    fun compare(
        base: String,
        firstTarget: String,
        secondTarget: String,
        amount: String
    ) {
        viewModelScope.launch {
            _state.value = CurrencyComparisonState(isLoading = true)
            currencyComparisonUseCase(
                base = base,
                firstTarget = firstTarget,
                secondTarget = secondTarget,
                amount = amount
            ).let { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = CurrencyComparisonState(isLoading = false)
                        _state.value = CurrencyComparisonState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d(
                            "hhh",
                            result.data.firstConversionValue.toString() + "  " + result.data.secondConversionValue.toString()
                        )
                        _state.value = CurrencyComparisonState(isLoading = false)
                        _state.value = CurrencyComparisonState(value = result.data)

                    }
                }
            }
        }

    }

    fun setAmountState(amount: String) {
       enteringAmount.value = amount
    }
}