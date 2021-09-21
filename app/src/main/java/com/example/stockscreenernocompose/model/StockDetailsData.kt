package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockDetailsData(
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("endDate")
    val endDate: String? = "",
    @SerializedName("exchangeCode")
    val exchangeCode: String? = "",
    @SerializedName("ticker")
    val ticker: String? = "",
    @SerializedName("description")
    val description: String? = ""
) : Parcelable
