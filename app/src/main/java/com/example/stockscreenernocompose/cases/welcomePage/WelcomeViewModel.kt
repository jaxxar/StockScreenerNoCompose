package com.example.stockscreenernocompose.cases.welcomePage

import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.domain.DomainModel
import com.example.stockscreenernocompose.utils.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun validateSymbol(symbol: String): Int {
        val trimmedSymbol = symbol.replace(" ", "")
        return if (trimmedSymbol.isBlank()) {
            R.string.app_ticker_symbol
        } else 0
    }

    suspend fun getStockData(symbol: String): DomainModel {
        return WelcomeInterceptor(repository, symbol).fetchData()
    }
}