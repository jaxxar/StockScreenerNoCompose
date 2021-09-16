package com.example.stockscreenernocompose.model

import com.google.gson.annotations.SerializedName

data class StockHistoryData(
    @SerializedName("name")
    val name: String? = null
)
