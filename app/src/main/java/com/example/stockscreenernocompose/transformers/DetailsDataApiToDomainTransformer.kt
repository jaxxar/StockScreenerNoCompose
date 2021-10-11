package com.example.stockscreenernocompose.transformers

import com.example.stockscreenernocompose.domain.DomainStockDetailsData
import com.example.stockscreenernocompose.model.StockDetailsData

class DetailsDataApiToDomainTransformer {

    fun transform(api: StockDetailsData): DomainStockDetailsData {
        val domain = DomainStockDetailsData()
        domain.description = api.description
        domain.endDate = api.endDate
        domain.startDate = api.startDate
        domain.exchangeCode = api.exchangeCode
        domain.name = api.name
        domain.ticker = api.ticker
        domain.requestResult = true
        domain.requestCode = 200

        return domain
    }
}