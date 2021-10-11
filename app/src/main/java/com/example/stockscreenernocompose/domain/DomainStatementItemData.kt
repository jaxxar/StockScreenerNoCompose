package com.example.stockscreenernocompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainStatementItemData(
    var dataCode: String? = "",
    var value: Double? = 0.0
) : Parcelable
