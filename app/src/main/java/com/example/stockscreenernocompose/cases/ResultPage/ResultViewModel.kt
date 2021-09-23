package com.example.stockscreenernocompose.cases.ResultPage

import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.model.StockDailyData
import com.example.stockscreenernocompose.model.StockStatementsData
import java.text.DecimalFormat

class ResultViewModel : ViewModel() {

    val formatter = DecimalFormat("#,###.00")

    fun validatePE(pe: Double): Boolean {
        return pe <= 20.0
    }

    fun validatePB(pb: Double): Boolean {
        return pb <= 3.0
    }

    fun validatePEG(peg: Float): Boolean {
        return peg <= 1.0
    }

    fun validateFreeCashFlow(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestFreeCashFlow = 0.0
        var oldestFreeCashFlow = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                latestFreeCashFlow = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                oldestFreeCashFlow = it.value ?: 0.0
            }
        }
        return latestFreeCashFlow > oldestFreeCashFlow
    }

    fun returnFreeCashFlow(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestFreeCashFlow = 0.0
        var oldestFreeCashFlow = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                latestFreeCashFlow = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                oldestFreeCashFlow = it.value ?: 0.0
            }
        }
        return "${formatter.format(oldestFreeCashFlow)}-->${formatter.format(latestFreeCashFlow)}"
    }

    fun validateTotalShares(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestTotalShares = 0.0
        var oldestTotalShares = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                latestTotalShares = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                oldestTotalShares = it.value ?: 0.0
            }
        }
        return latestTotalShares < oldestTotalShares
    }

    fun returnTotalShares(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestTotalShares = 0.0
        var oldestTotalShares = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                latestTotalShares = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                oldestTotalShares = it.value ?: 0.0
            }
        }
        return "${formatter.format(oldestTotalShares)}-->${formatter.format(latestTotalShares)}"
    }

    fun validateRevenue(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestRevenue = 0.0
        var oldestRevenue = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                latestRevenue = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                oldestRevenue = it.value ?: 0.0
            }
        }
        return latestRevenue > oldestRevenue
    }

    fun returnRevenue(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestRevenue = 0.0
        var oldestRevenue = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                latestRevenue = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                oldestRevenue = it.value ?: 0.0
            }
        }
        return "${formatter.format(oldestRevenue)}-->${formatter.format(latestRevenue)}"
    }

    fun validateNetIncome(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestNetIncome = 0.0
        var oldestNetIncome = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                latestNetIncome = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                oldestNetIncome = it.value ?: 0.0
            }
        }
        return latestNetIncome > oldestNetIncome
    }

    fun returnNetIncome(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestNetIncome = 0.0
        var oldestNetIncome = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                latestNetIncome = it.value ?: 0.0
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                oldestNetIncome = it.value ?: 0.0
            }
        }
        return "${formatter.format(oldestNetIncome)}-->${formatter.format(latestNetIncome)}"
    }

    fun validateROIC(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var netIncome = 0.0
        var dividend = 0.0
        var dept = 0.0
        var equity = 0.0
        var validation = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.incomeStatement?.forEach {
                if (it.dataCode.equals("netinc")) {
                    netIncome += it.value ?: 0.0
                }
            }
            it.statementData?.balanceSheet?.forEach {
                if (it.dataCode.equals("equity")) {
                    equity += it.value ?: 0.0
                }
                if (it.dataCode.equals("dept")) {
                    dept += it.value ?: 0.0
                }
            }
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("payDiv")) {
                    dividend += it.value ?: 0.0
                }
            }
            validation = (((netIncome - dividend) / (dept + equity)) / yearlyData.size) * 100
        }

        return validation > 9.0
    }

    fun returnROIC(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var netIncome = 0.0
        var dividend = 0.0
        var dept = 0.0
        var equity = 0.0
        var validation = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.incomeStatement?.forEach {
                if (it.dataCode.equals("netinc")) {
                    netIncome += it.value ?: 0.0
                }
            }
            it.statementData?.balanceSheet?.forEach {
                if (it.dataCode.equals("equity")) {
                    equity += it.value ?: 0.0
                }
                if (it.dataCode.equals("dept")) {
                    dept += it.value ?: 0.0
                }
            }
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("payDiv")) {
                    dividend += it.value ?: 0.0
                }
            }
            validation = (((netIncome - dividend) / (dept + equity)) / yearlyData.size) * 100
        }

        return formatter.format(validation)
    }

    fun validateLiabilities(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var averageFreeCashFlow = 0.0
        var totalLiabilities = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("freeCashFlow")) {
                    averageFreeCashFlow += it.value ?: 0.0
                }
            }
        }
        yearlyData.first().statementData?.balanceSheet?.forEach {
            if (it.dataCode.equals("liabilitiesNonCurrent")) {
                totalLiabilities = it.value ?: 0.0
            }
        }

        return (totalLiabilities / (averageFreeCashFlow / yearlyData.size)) < 5
    }

    fun returnLiabilities(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var averageFreeCashFlow = 0.0
        var totalLiabilities = 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("freeCashFlow")) {
                    averageFreeCashFlow += it.value ?: 0.0
                }
            }
        }
        yearlyData.first().statementData?.balanceSheet?.forEach {
            if (it.dataCode.equals("liabilitiesNonCurrent")) {
                totalLiabilities = it.value ?: 0.0
            }
        }

        return formatter.format(totalLiabilities / (averageFreeCashFlow / yearlyData.size))
    }

    fun validatePriceToAverageFreeCashFlow(
        data: Array<StockStatementsData>,
        dailyData: StockDailyData
    ): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var averageFreeCashFlow = 0.0
        val marketCap = dailyData.marketCap ?: 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("freeCashFlow")) {
                    averageFreeCashFlow += it.value ?: 0.0
                }
            }
        }
        averageFreeCashFlow /= yearlyData.size


        return (averageFreeCashFlow * 20) > marketCap
    }

    fun returnPriceToAverageFreeCashFlow(
        data: Array<StockStatementsData>,
        dailyData: StockDailyData
    ): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var averageFreeCashFlow = 0.0
        val marketCap = dailyData.marketCap ?: 0.0
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("freeCashFlow")) {
                    averageFreeCashFlow += it.value ?: 0.0
                }
            }
        }
        averageFreeCashFlow = averageFreeCashFlow / yearlyData.size * 20


        return "20 year average free cash flow = ${formatter.format(averageFreeCashFlow)} \n market cap = ${
            formatter.format(
                marketCap
            )
        }"
    }

}