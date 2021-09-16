package com.example.stockscreenernocompose.cases.welcomePage

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.model.StockDetailsData
import com.example.stockscreenernocompose.utils.Constants
import com.example.stockscreenernocompose.utils.network.StocksAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val api: StocksAPI) : ViewModel() {

    fun validateSymbol(symbol: String): Int {
        val trimmedSymbol = symbol.replace(" ", "")
        return if (trimmedSymbol.isBlank()) {
            R.string.app_ticker_symbol
        } else 0
    }

    suspend fun getStockDetails(symbol: String): StockDetailsData {
        val result = api.getStockDetails(symbol, Constants.API_KEY_VALUE)
        Log.d("TAG", "${result.name}")
        delay(1000)
        return result
    }
}