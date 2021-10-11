package com.example.stockscreenernocompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainStockStatementsData(
    var requestResult: Boolean = true,
    var requestCode: Int = 200,
    var date: String? = "",
    var year: String? = "",
    var statementData: DomainStatementContentData? = null,
    var quarter: String? = ""
) : Parcelable
