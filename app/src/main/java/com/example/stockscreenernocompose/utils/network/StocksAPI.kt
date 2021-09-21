package com.example.stockscreenernocompose.utils.network

import com.example.stockscreenernocompose.model.StockDailyData
import com.example.stockscreenernocompose.model.StockDetailsData
import com.example.stockscreenernocompose.model.StockStatementsData
import com.example.stockscreenernocompose.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StocksAPI {

    @GET("{daily}/{ticker}")
    suspend fun getStockDetails(
        @Path("daily") daily: String,
        @Path("ticker") ticker: String,
        @Query(Constants.API_KEY) apiKey: String
    ): StockDetailsData

    @GET("{fundamentals}/{ticker}/{daily}")
    suspend fun getDailyData(
        @Path("fundamentals") fundamentals: String,
        @Path("ticker") ticker: String,
        @Path("daily") daily: String,
        @Query(Constants.API_KEY) apiKey: String
    ): Array<StockDailyData>

    @GET("{fundamentals}/{ticker}/{statements}")
    suspend fun getStatementsData(
        @Path("fundamentals") fundamentals: String,
        @Path("ticker") ticker: String,
        @Path("statements") statements: String,
        @Query(Constants.API_KEY) apiKey: String
    ): Array<StockStatementsData>
}