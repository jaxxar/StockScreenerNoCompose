package com.example.stockscreenernocompose.cases.welcomePage

import com.example.stockscreenernocompose.domain.DomainModel
import com.example.stockscreenernocompose.domain.DomainStockDailyData
import com.example.stockscreenernocompose.domain.DomainStockDetailsData
import com.example.stockscreenernocompose.domain.DomainStockStatementsData
import com.example.stockscreenernocompose.model.StockDailyData
import com.example.stockscreenernocompose.model.StockDetailsData
import com.example.stockscreenernocompose.model.StockStatementsData
import com.example.stockscreenernocompose.transformers.DailyDataApiToDomainTransformer
import com.example.stockscreenernocompose.transformers.DetailsDataApiToDomainTransformer
import com.example.stockscreenernocompose.transformers.StatementDataApiToDomainTransformer
import com.example.stockscreenernocompose.utils.Constants
import com.example.stockscreenernocompose.utils.network.ErrorResponseMapper
import com.example.stockscreenernocompose.utils.network.Repository
import com.skydoves.sandwich.map
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess


class WelcomeInterceptor(private val repository: Repository, private val symbol: String) {

    suspend fun fetchData(): DomainModel {
        val data = DomainModel()

        val domainDetailsData = getDetailsData()
        val domainDailyData = getDailyData()
        val domainStatementsData = getStatementsData()
        if (domainDetailsData.requestResult && domainDailyData.first().requestResult && domainStatementsData.first().requestResult) {
            data.domainStockDetailsData = domainDetailsData
            data.domainStockDailyData = domainDailyData
            data.domainStockStatementsData = domainStatementsData
            data.requestResult = true
            data.requestCode = 200
        } else {
            data.requestResult = false
            data.requestCode = domainDetailsData.requestCode
        }

        return data
    }

    private suspend fun getDetailsData(): DomainStockDetailsData {
        var apiDetailsData: StockDetailsData
        var domainDetailsData = DomainStockDetailsData()
        repository.getStockDetails(
            Constants.API_ENDPOINT_DAILY_DATA,
            symbol,
            Constants.API_KEY_VALUE
        ).suspendOnSuccess {
            apiDetailsData = this.data
            domainDetailsData = DetailsDataApiToDomainTransformer().transform(apiDetailsData)
        }.onError {
            map(ErrorResponseMapper) {
                domainDetailsData.requestResult = false
                domainDetailsData.requestCode = this.code
            }
        }.onException {
            domainDetailsData.requestResult = false
        }
        return domainDetailsData
    }

    private suspend fun getDailyData(): ArrayList<DomainStockDailyData> {
        var apiDailyData: ArrayList<StockDailyData>
        var domainDailyData = ArrayList<DomainStockDailyData>()
        repository.getDailyData(
            Constants.API_ENDPOINT_FUNDAMENTALS,
            symbol,
            Constants.API_ENDPOINT_DAILY_DATA,
            Constants.API_KEY_VALUE
        ).suspendOnSuccess {
            apiDailyData = this.data
            domainDailyData = DailyDataApiToDomainTransformer().transform(apiDailyData)
        }.onError {
            map(ErrorResponseMapper) {
                domainDailyData.add(
                    DomainStockDailyData(
                        requestResult = false,
                        requestCode = this.code
                    )
                )
            }
        }.onException {
            domainDailyData.add(DomainStockDailyData(requestResult = false))
        }
        return domainDailyData
    }

    private suspend fun getStatementsData(): ArrayList<DomainStockStatementsData> {
        var apiStatementsData: ArrayList<StockStatementsData>
        var domainStatementsData = ArrayList<DomainStockStatementsData>()
        repository.getStatementsData(
            Constants.API_ENDPOINT_FUNDAMENTALS,
            symbol,
            Constants.API_ENDPOINT_STATEMENT_DATA,
            Constants.API_KEY_VALUE
        ).suspendOnSuccess {
            apiStatementsData = this.data
            domainStatementsData =
                StatementDataApiToDomainTransformer().transform(apiStatementsData)

        }.onError {
            map(ErrorResponseMapper) {
                domainStatementsData.add(
                    DomainStockStatementsData(
                        requestResult = false,
                        requestCode = this.code
                    )
                )
            }
        }.onException {
            domainStatementsData.add(DomainStockStatementsData(requestResult = false))
        }
        return domainStatementsData
    }
}