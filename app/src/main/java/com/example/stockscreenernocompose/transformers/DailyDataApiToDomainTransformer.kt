package com.example.stockscreenernocompose.transformers

import com.example.stockscreenernocompose.domain.DomainStockDailyData
import com.example.stockscreenernocompose.model.StockDailyData

class DailyDataApiToDomainTransformer {

    fun transform(api: ArrayList<StockDailyData>): ArrayList<DomainStockDailyData> {
        val domain = ArrayList<DomainStockDailyData>()
        api.forEach {
            domain.add(
                DomainStockDailyData(
                    requestCode = 200,
                    requestResult = true,
                    date = it.date,
                    marketCap = it.marketCap,
                    enterpriseVal = it.enterpriseVal,
                    peRatio = it.peRatio,
                    pbRatio = it.pbRatio,
                    trailingPEG1Y = it.trailingPEG1Y
                )
            )
        }

        return domain
    }
}