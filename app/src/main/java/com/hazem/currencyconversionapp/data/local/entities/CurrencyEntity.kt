package com.hazem.currencyconversionapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey
    val id: Int? = null,
    val currency: String
)
