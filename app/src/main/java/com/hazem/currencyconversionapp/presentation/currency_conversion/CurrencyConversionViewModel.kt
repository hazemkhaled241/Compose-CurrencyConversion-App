package com.hazem.currencyconversionapp.presentation.currency_conversion

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.currencyconversionapp.domain.use_case.local.AddCurrencyToFavoriteUseCase
import com.hazem.currencyconversionapp.domain.use_case.local.DeleteFromFavoritesUseCase
import com.hazem.currencyconversionapp.domain.use_case.local.GetAllFavoriteCurrenciesUseCase
import com.hazem.currencyconversionapp.domain.use_case.remote.ConvertCurrencyUseCase
import com.hazem.currencyconversionapp.domain.use_case.remote.GetAllFavoritesUseCase
import com.hazem.currencyconversionapp.presentation.currencies.AddCurrencyState
import com.hazem.currencyconversionapp.presentation.currencies.DeleteCurrencyState
import com.hazem.currencyconversionapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConversionViewModel @Inject constructor(
    private val currencyUseCase: ConvertCurrencyUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    private val getAllFavoriteCurrenciesUseCase: GetAllFavoriteCurrenciesUseCase,
    private val addCurrencyToFavoriteUseCase: AddCurrencyToFavoriteUseCase,
    private val deleteFromFavoritesUseCase: DeleteFromFavoritesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CurrencyConversionState())
    val state: State<CurrencyConversionState> = _state

    private val _currencyDetailsState = mutableStateOf(FavoritesDetailsState())
    val currencyDetailsState: State<FavoritesDetailsState> = _currencyDetailsState


    private val _getAllFavoriteCurrencyState = mutableStateOf(GetAllFavoriteCurrencyState())
    val getAllFavoriteCurrencyState: State<GetAllFavoriteCurrencyState> =
        _getAllFavoriteCurrencyState

    private val _addCurrencyState = mutableStateOf(AddCurrencyState())
    val addCurrencyState: State<AddCurrencyState> = _addCurrencyState

    private val _deleteCurrencyState = mutableStateOf(DeleteCurrencyState())
    val deleteCurrencyState: State<DeleteCurrencyState> = _deleteCurrencyState

    private val _amountState = mutableStateOf(CurrencyConversionState())
    val amountState: State<CurrencyConversionState> = _amountState

    init {
        getAllCurrencyFromFavorite()

    }

    fun onEvent(event: CurrencyEvents) {
        when (event) {
            is CurrencyEvents.AddToFavorite -> {
                Log.d("hhhh", "added")
                viewModelScope.launch {
                    addCurrencyToFavoriteUseCase(event.currencyEntity)
                }
            }

            is CurrencyEvents.DeleteFromFavorites -> {
                viewModelScope.launch {
                    deleteFromFavoritesUseCase(event.currencyEntity)
                }
            }

            CurrencyEvents.GetAllFavoriteCurrencies -> {
                viewModelScope.launch {
                    getAllFavoriteCurrenciesUseCase()
                }
            }

            is CurrencyEvents.GetFavoritesDetails -> {
                viewModelScope.launch {
                    getFavoritesDetails(base = event.base, favorites = event.currencies)
                }
            }
        }
    }

    fun convertCurrency(
        base: String,
        target: String,
        amount: String
    ) {
        viewModelScope.launch {
            _state.value = CurrencyConversionState(isLoading = true)
            currencyUseCase(base = base, target = target, amount = amount).let { result ->
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

    private fun getFavoritesDetails(
        base: String,
        favorites: List<String>,
    ) {
        viewModelScope.launch {
            _currencyDetailsState.value = FavoritesDetailsState(isLoading = true)
            getAllFavoritesUseCase(base = base, favorites = favorites).let { result ->
                when (result) {
                    is Resource.Error -> {
                        _currencyDetailsState.value = FavoritesDetailsState(isLoading = false)
                        _currencyDetailsState.value = FavoritesDetailsState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d("kkk", result.data.toString())
                        _currencyDetailsState.value = FavoritesDetailsState(isLoading = false)
                        _currencyDetailsState.value = FavoritesDetailsState(favorites = result.data)

                    }
                }
            }
        }

    }

    fun setAmountState(amount: String) {
        _state.value = CurrencyConversionState(amount = amount)
    }

    private fun getAllCurrencyFromFavorite() {
        viewModelScope.launch {
            _getAllFavoriteCurrencyState.value =
                GetAllFavoriteCurrencyState(isLoading = true)
            getAllFavoriteCurrenciesUseCase().let { result ->
                when (result) {
                    is Resource.Error -> {
                        Log.d("error", result.message)
                        _getAllFavoriteCurrencyState.value =
                            GetAllFavoriteCurrencyState(isLoading = false)
                        _getAllFavoriteCurrencyState.value =
                            GetAllFavoriteCurrencyState(error = result.message)
                    }

                    is Resource.Success -> {
                        Log.d("allFav", result.data.toString())
                        _getAllFavoriteCurrencyState.value =
                            GetAllFavoriteCurrencyState(isLoading = false)
                        _getAllFavoriteCurrencyState.value =
                            GetAllFavoriteCurrencyState(allCurrency = result.data)
                    }
                }

            }
        }
    }


}