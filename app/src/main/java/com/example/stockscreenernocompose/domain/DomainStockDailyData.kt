package com.example.stockscreenernocompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainStockDailyData(
    var requestResult: Boolean = true,
    var requestCode: Int = 200,
    var date: String? = "",
    var marketCap: Double? = 0.0,
    var enterpriseVal: Double? = 0.0,
    var peRatio: Double? = 0.0,
    var pbRatio: Double? = 0.0,
    var trailingPEG1Y: String? = ""
) : Parcelable {
    constructor() : this(
        true, 200,
        "", 0.0, 0.0,
        0.0, 0.0, ""
    )
}
