package com.hazem.currencyconversionapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity

@Dao
interface CurrencyDao {

    @Query(value = "SELECT * FROM currency")
    suspend fun getFavCurrencies():List<CurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(fav: CurrencyEntity)

    @Delete
    suspend fun deleteFromFavorites(currency: CurrencyEntity)
}