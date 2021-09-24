package com.example.stockscreenernocompose.utils.network

import javax.inject.Inject

class Repository @Inject constructor(private val api: StocksAPI) {

    suspend fun getStockDetails(daily: String, ticker: String, apiKey: String) =
        api.getStockDetails(daily, ticker, apiKey)

    suspend fun getDailyData(fundamentals: String, ticker: String, daily: String, apiKey: String) =
        api.getDailyData(fundamentals, ticker, daily, apiKey)

    suspend fun getStatementsData(
        fundamentals: String,
        ticker: String,
        statements: String,
        apiKey: String
    ) = api.getStatementsData(fundamentals, ticker, statements, apiKey)

}