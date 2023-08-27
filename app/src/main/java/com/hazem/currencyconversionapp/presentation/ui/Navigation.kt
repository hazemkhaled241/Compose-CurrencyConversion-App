package com.hazem.currencyconversionapp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hazem.currencyconversionapp.presentation.MainScreen
import com.hazem.currencyconversionapp.presentation.currency_conversion.components.Favorite

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable("favorite") {
           Favorite(navController = navController)
        }
    }
}