package com.hazem.currencyconversionapp.presentation.currencies

 import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.domain.use_case.remote.GetCurrenciesUseCase
import com.hazem.currencyconversionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CurrencyState())
    val state: State<CurrencyState> = _state

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        viewModelScope.launch {
            _state.value = CurrencyState(isLoading = true)
            getCurrenciesUseCase().let { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = CurrencyState(isLoading = false)
                        _state.value = CurrencyState(error = result.message)
                    }

                    is Resource.Success -> {
                        _state.value = CurrencyState(isLoading = false)
                        _state.value = CurrencyState(currencyList = result.data)

                    }
                }
            }


        }
    }




}

