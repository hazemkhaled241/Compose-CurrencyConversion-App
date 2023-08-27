package com.hazem.currencyconversionapp.presentation.currencies

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity
import com.hazem.currencyconversionapp.domain.use_case.local.AddCurrencyToFavoriteUseCase
import com.hazem.currencyconversionapp.domain.use_case.local.DeleteFromFavoritesUseCase
import com.hazem.currencyconversionapp.domain.use_case.remote.GetCurrenciesUseCase
import com.hazem.currencyconversionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val addCurrencyToFavoriteUseCase: AddCurrencyToFavoriteUseCase,
    private val deleteFromFavoritesUseCase: DeleteFromFavoritesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CurrencyState())
    val state: State<CurrencyState> = _state

    private val _addCurrencyState = mutableStateOf(AddCurrencyState())
    val addCurrencyState: State<AddCurrencyState> = _addCurrencyState

    private val _deleteCurrencyState = mutableStateOf(DeleteCurrencyState())
    val deleteCurrencyState: State<DeleteCurrencyState> = _deleteCurrencyState


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
                        Log.d("hhh", result.data.toString())
                        _state.value = CurrencyState(isLoading = false)
                        _state.value = CurrencyState(currencyList = result.data)

                    }
                }
            }


        }
    }

    fun addCurrencyToFavorite(currency: CurrencyEntity) {
        viewModelScope.launch {
            _addCurrencyState.value = AddCurrencyState(isLoading = true)
            addCurrencyToFavoriteUseCase(currency).let { result ->
                when (result) {
                    is Resource.Error -> {
                        _addCurrencyState.value = AddCurrencyState(isLoading = false)
                        _addCurrencyState.value = AddCurrencyState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d("insert", result.data)
                        _addCurrencyState.value = AddCurrencyState(isLoading = false)

                    }
                }

            }
        }
    }

    fun deleteCurrencyToFavorite(currency: CurrencyEntity) {
        viewModelScope.launch {
            _deleteCurrencyState.value = DeleteCurrencyState(isLoading = true)
            deleteFromFavoritesUseCase(currency).let { result ->
                when (result) {
                    is Resource.Error -> {
                        _deleteCurrencyState.value = DeleteCurrencyState(isLoading = false)
                        _deleteCurrencyState.value = DeleteCurrencyState(error = result.message)

                    }

                    is Resource.Success -> {
                        Log.d("delete", result.data)
                        _deleteCurrencyState.value = DeleteCurrencyState(isLoading = false)
                    }
                }

            }
        }
    }


}

