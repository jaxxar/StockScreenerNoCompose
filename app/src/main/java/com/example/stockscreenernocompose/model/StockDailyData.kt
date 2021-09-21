package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockDailyData(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("marketCap")
    val marketCap: String? = "",
    @SerializedName("enterpriseVal")
    val enterpriseVal: String? = "",
    @SerializedName("peRatio")
    val peRatio: String? = "",
    @SerializedName("pbRatio")
    val pbRatio: String? = "",
    @SerializedName("trailingPEG1Y")
    val trailingPEG1Y: String? = ""
) : Parcelable
