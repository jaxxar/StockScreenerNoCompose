package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockStatementsData(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("year")
    val year: String? = "",
    @SerializedName("statementData")
    val statementData: StatementContentData? = null,
    @SerializedName("quarter")
    val quarter: String? = ""
) : Parcelable
