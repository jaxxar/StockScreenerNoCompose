package com.example.stockscreenernocompose.cases.welcomePage

import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.model.StockDailyData
import com.example.stockscreenernocompose.model.StockDetailsData
import com.example.stockscreenernocompose.model.StockStatementsData
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
        val result =
            api.getStockDetails(Constants.API_ENDPOINT_DAILY_DATA, symbol, Constants.API_KEY_VALUE)
        delay(500)
        return result
    }

    suspend fun getDailyData(symbol: String): Array<StockDailyData> {
        val result = api.getDailyData(
            Constants.API_ENDPOINT_FUNDAMENTALS,
            symbol,
            Constants.API_ENDPOINT_DAILY_DATA,
            Constants.API_KEY_VALUE
        )
        delay(500)
        return result
    }

    suspend fun getStatementData(symbol: String): Array<StockStatementsData> {
        val result = api.getStatementsData(
            Constants.API_ENDPOINT_FUNDAMENTALS,
            symbol,
            Constants.API_ENDPOINT_STATEMENT_DATA,
            Constants.API_KEY_VALUE
        )
        delay(500)
        return result
    }

}