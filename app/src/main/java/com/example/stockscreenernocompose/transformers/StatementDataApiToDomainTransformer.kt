package com.example.stockscreenernocompose.transformers

import com.example.stockscreenernocompose.domain.DomainStatementContentData
import com.example.stockscreenernocompose.domain.DomainStatementItemData
import com.example.stockscreenernocompose.domain.DomainStockStatementsData
import com.example.stockscreenernocompose.model.StatementItemData
import com.example.stockscreenernocompose.model.StockStatementsData

class StatementDataApiToDomainTransformer {

    fun transform(api: ArrayList<StockStatementsData>): ArrayList<DomainStockStatementsData> {
        val domain = ArrayList<DomainStockStatementsData>()

        api.forEach {
            domain.add(
                DomainStockStatementsData(
                    requestCode = 200,
                    requestResult = true,
                    date = it.date,
                    year = it.year,
                    statementData = DomainStatementContentData(
                        incomeStatement = addItem(it.statementData?.incomeStatement),
                        overview = addItem(it.statementData?.overview),
                        cashFlow = addItem(it.statementData?.cashFlow),
                        balanceSheet = addItem(it.statementData?.balanceSheet)
                    ),
                    quarter = it.quarter
                )
            )
        }
        return domain
    }

    private fun addItem(item: List<StatementItemData>?): ArrayList<DomainStatementItemData> {
        val domainItem = ArrayList<DomainStatementItemData>()

        item?.forEach {
            domainItem.add(
                DomainStatementItemData(
                    dataCode = it.dataCode,
                    value = it.value
                )
            )
        }
        return domainItem
    }
}
