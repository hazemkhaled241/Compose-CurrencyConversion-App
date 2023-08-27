package com.hazem.currencyconversionapp.presentation.currency_conversion.components

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun CircleCheckBox(
    selected: Boolean,
    modifier: Modifier,
    onChecked: (Boolean) -> Unit,
) {
    Log.d("selected", selected.toString())
    val icon = if (selected) Icons.Filled.CheckCircle else Icons.Outlined.Circle
    IconButton(
        onClick = {
            onChecked(selected)
        },
        modifier = modifier,
    ) {
        Icon(imageVector = icon, contentDescription = "Check icon")
    }
}