package com.example.stockscreenernocompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainStockDetailsData(
    var requestResult: Boolean = true,
    var requestCode: Int = 200,
    var startDate: String? = "",
    var name: String? = "",
    var endDate: String? = "",
    var exchangeCode: String? = "",
    var ticker: String? = "",
    var description: String? = ""
) : Parcelable {
    constructor() : this(
        true, 200,
        "", "", "",
        "", "", ""
    )
}
