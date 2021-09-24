package com.example.stockscreenernocompose.cases.welcomePage

import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.model.StockDailyData
import com.example.stockscreenernocompose.model.StockDetailsData
import com.example.stockscreenernocompose.model.StockStatementsData
import com.example.stockscreenernocompose.utils.Constants
import com.example.stockscreenernocompose.utils.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun validateSymbol(symbol: String): Int {
        val trimmedSymbol = symbol.replace(" ", "")
        return if (trimmedSymbol.isBlank()) {
            R.string.app_ticker_symbol
        } else 0
    }

    suspend fun getStockDetails(symbol: String): StockDetailsData {
        return repository.getStockDetails(
            Constants.API_ENDPOINT_DAILY_DATA,
            symbol,
            Constants.API_KEY_VALUE
        )
    }

    suspend fun getDailyData(symbol: String): Array<StockDailyData> {
        return repository.getDailyData(
            Constants.API_ENDPOINT_FUNDAMENTALS,
            symbol,
            Constants.API_ENDPOINT_DAILY_DATA,
            Constants.API_KEY_VALUE
        )
    }

    suspend fun getStatementData(symbol: String): Array<StockStatementsData> {
        return repository.getStatementsData(
            Constants.API_ENDPOINT_FUNDAMENTALS,
            symbol,
            Constants.API_ENDPOINT_STATEMENT_DATA,
            Constants.API_KEY_VALUE
        )
    }
}