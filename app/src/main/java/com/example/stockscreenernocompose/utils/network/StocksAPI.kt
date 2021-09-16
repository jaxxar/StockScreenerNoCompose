package com.example.stockscreenernocompose.utils.network

import com.example.stockscreenernocompose.model.StockDetailsData
import com.example.stockscreenernocompose.model.StockHistoryData
import com.example.stockscreenernocompose.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StocksAPI {

    @GET("{ticker}/${Constants.API_ENDPOINT_HISTORY}")
    suspend fun getStockHistory(
        @Path("ticker") ticker: String,
        @Query(Constants.API_KEY) apiKey: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("resampleFreq") resampleFreq: String
    ): StockHistoryData

    @GET("{ticker}")
    suspend fun getStockDetails(
        @Path("ticker") ticker: String,
        @Query(Constants.API_KEY) apiKey: String
    ): StockDetailsData
}