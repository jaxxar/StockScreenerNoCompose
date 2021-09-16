package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockDetailsData(
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("endDate")
    val endDate: String? = "",
    @SerializedName("exchangeCode")
    val exchangeCode: String? = null,
    @SerializedName("ticker")
    val ticker: String? = "",
    @SerializedName("description")
    val description: String? = null
) : Parcelable
