package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatementContentData(
    @SerializedName("incomeStatement")
    val incomeStatement: List<StatementItemData>? = null,
    @SerializedName("overview")
    val overview: List<StatementItemData>? = null,
    @SerializedName("cashFlow")
    val cashFlow: List<StatementItemData>? = null,
    @SerializedName("balanceSheet")
    val balanceSheet: List<StatementItemData>? = null
) : Parcelable
