package com.example.stockscreenernocompose.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatementItemData(
    @SerializedName("dataCode")
    val dataCode: String? = "",
    @SerializedName("value")
    val value: Double? = 0.0
) : Parcelable
