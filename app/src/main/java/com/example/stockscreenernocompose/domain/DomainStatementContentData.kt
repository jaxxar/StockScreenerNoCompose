package com.example.stockscreenernocompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainStatementContentData(
    var incomeStatement: List<DomainStatementItemData>? = null,
    var overview: List<DomainStatementItemData>? = null,
    var cashFlow: List<DomainStatementItemData>? = null,
    var balanceSheet: List<DomainStatementItemData>? = null
) : Parcelable
