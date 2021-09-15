package com.example.stockscreenernocompose.cases.welcomePage

import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.R

class WelcomeViewModel : ViewModel() {

    fun validateSymbol(symbol: String): Int {
        val trimmedSymbol = symbol.replace(" ", "")
        return if (trimmedSymbol.isBlank()) {
            R.string.app_ticker_symbol
        } else 0
    }
}