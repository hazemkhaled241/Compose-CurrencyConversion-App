package com.hazem.currencyconversionapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hazem.currencyconversionapp.data.local.entities.CurrencyEntity

@Database(entities = [CurrencyEntity::class], version = 1, exportSchema = false)
abstract class CurrencyDataBase: RoomDatabase() {
    abstract fun currencyDao():CurrencyDao
    companion object{
        @Volatile
        private var INSTANCE: CurrencyDataBase?=null
        fun getDataBase(context: Context): CurrencyDataBase {
            val tempInstance= INSTANCE
            if(tempInstance!=null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurrencyDataBase::class.java,
                    "currency"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}