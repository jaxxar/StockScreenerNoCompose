package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockDailyData(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("marketCap")
    val marketCap: Double? = 0.0,
    @SerializedName("enterpriseVal")
    val enterpriseVal: Double? = 0.0,
    @SerializedName("peRatio")
    val peRatio: Double? = 0.0,
    @SerializedName("pbRatio")
    val pbRatio: Double? = 0.0,
    @SerializedName("trailingPEG1Y")
    val trailingPEG1Y: String? = ""
) : Parcelable
