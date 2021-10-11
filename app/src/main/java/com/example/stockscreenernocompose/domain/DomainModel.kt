package com.example.stockscreenernocompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainModel(
    var requestResult: Boolean = true,
    var requestCode: Int = 200,
    var domainStockDetailsData: DomainStockDetailsData,
    var domainStockDailyData: ArrayList<DomainStockDailyData>,
    var domainStockStatementsData: ArrayList<DomainStockStatementsData>
) : Parcelable {
    constructor() : this(
        true,
        200,
        DomainStockDetailsData(),
        ArrayList<DomainStockDailyData>(),
        ArrayList<DomainStockStatementsData>()
    )
}
