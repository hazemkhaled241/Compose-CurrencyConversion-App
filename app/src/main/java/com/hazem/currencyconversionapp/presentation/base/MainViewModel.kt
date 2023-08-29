package com.hazem.currencyconversionapp.presentation.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor():ViewModel() {

    var isConvertClickedState = mutableStateOf(true)

    var isCompareClickedState = mutableStateOf(false)

    private var _pageNameState = mutableStateOf("Currency Converter")
    var pageNameState :String = _pageNameState.value

    fun update(bool:Boolean , bool2: Boolean){
        isConvertClickedState.value = bool
        isCompareClickedState.value = bool2
    }

}