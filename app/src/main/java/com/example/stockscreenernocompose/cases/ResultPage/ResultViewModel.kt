package com.example.stockscreenernocompose.cases.ResultPage

import androidx.lifecycle.ViewModel
import com.example.stockscreenernocompose.model.StockStatementsData

class ResultViewModel: ViewModel() {

    fun validatePE(pe: Float): Boolean {
        return pe <= 20.0
    }

    fun validateFreeCashFlow(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestFreeCashFlow = 0.0f
        var oldestFreeCashFlow = 0.0f
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                latestFreeCashFlow = it.value?.toFloat() ?: 0.0f
            }
        }
        yearlyData.last().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                oldestFreeCashFlow = it.value?.toFloat() ?: 0.0f
            }
        }
        return latestFreeCashFlow > oldestFreeCashFlow
    }

    fun returnFreeCashFlow(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestFreeCashFlow = ""
        var oldestFreeCashFlow = ""
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                latestFreeCashFlow = it.value.toString()
            }
        }
        yearlyData.last().statementData?.cashFlow?.forEach {
            if (it.dataCode.equals("freeCashFlow")) {
                oldestFreeCashFlow = it.value.toString()
            }
        }
        return "$oldestFreeCashFlow-->$latestFreeCashFlow"
    }

    fun validateTotalShares(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestTotalShares = 0.0f
        var oldestTotalShares = 0.0f
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                latestTotalShares = it.value?.toFloat() ?: 0.0f
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                oldestTotalShares = it.value?.toFloat() ?: 0.0f
            }
        }
        return latestTotalShares < oldestTotalShares
    }

    fun returnTotalShares(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestTotalShares = ""
        var oldestTotalShares = ""
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                latestTotalShares = it.value.toString()
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("shareswaDil")) {
                oldestTotalShares = it.value.toString()
            }
        }
        return "$oldestTotalShares-->$latestTotalShares"
    }

    fun validateRevenue(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestRevenue = 0.0f
        var oldestRevenue = 0.0f
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                latestRevenue = it.value?.toFloat() ?: 0.0f
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                oldestRevenue = it.value?.toFloat() ?: 0.0f
            }
        }
        return latestRevenue > oldestRevenue
    }

    fun returnRevenue(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestRevenue = ""
        var oldestRevenue = ""
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                latestRevenue = it.value.toString()
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("revenue")) {
                oldestRevenue = it.value.toString()
            }
        }
        return "$oldestRevenue-->$latestRevenue"
    }

    fun validateNetIncome(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestNetIncome = 0.0f
        var oldestNetIncome = 0.0f
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                latestNetIncome = it.value?.toFloat() ?: 0.0f
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                oldestNetIncome = it.value?.toFloat() ?: 0.0f
            }
        }
        return latestNetIncome > oldestNetIncome
    }

    fun returnNetIncome(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var latestNetIncome = ""
        var oldestNetIncome = ""
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.first().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                latestNetIncome = it.value.toString()
            }
        }
        yearlyData.last().statementData?.incomeStatement?.forEach {
            if (it.dataCode.equals("netinc")) {
                oldestNetIncome = it.value.toString()
            }
        }
        return "$oldestNetIncome-->$latestNetIncome"
    }

    fun validateROIC(data: Array<StockStatementsData>): Boolean {
        val yearlyData = arrayListOf<StockStatementsData>()
        var netIncome = 0.0f
        var dividend = 0.0f
        var dept = 0.0f
        var equity = 0.0f
        var validation = 0.0f
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.incomeStatement?.forEach {
                if (it.dataCode.equals("netinc")) {
                    netIncome += it.value?.toFloat() ?: 0.0f
                }
            }
            it.statementData?.balanceSheet?.forEach {
                if (it.dataCode.equals("equity")) {
                    equity += it.value?.toFloat() ?: 0.0f
                }
                if (it.dataCode.equals("dept")) {
                    dept += it.value?.toFloat() ?: 0.0f
                }
            }
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("payDiv")) {
                    dividend += it.value?.toFloat() ?: 0.0f
                }
            }
            validation = (((netIncome - dividend) / (dept + equity)) / yearlyData.size) * 100
        }

        return validation > 9.0f
    }

    fun returnROIC(data: Array<StockStatementsData>): String {
        val yearlyData = arrayListOf<StockStatementsData>()
        var netIncome = 0.0f
        var dividend = 0.0f
        var dept = 0.0f
        var equity = 0.0f
        var validation = 0.0f
        data.forEach {
            if (it.quarter.equals("0")) {
                yearlyData.add(it)
            }
        }
        yearlyData.forEach {
            it.statementData?.incomeStatement?.forEach {
                if (it.dataCode.equals("netinc")) {
                    netIncome += it.value?.toFloat() ?: 0.0f
                }
            }
            it.statementData?.balanceSheet?.forEach {
                if (it.dataCode.equals("equity")) {
                    equity += it.value?.toFloat() ?: 0.0f
                }
                if (it.dataCode.equals("dept")) {
                    dept += it.value?.toFloat() ?: 0.0f
                }
            }
            it.statementData?.cashFlow?.forEach {
                if (it.dataCode.equals("payDiv")) {
                    dividend += it.value?.toFloat() ?: 0.0f
                }
            }
            validation = (((netIncome - dividend) / (dept + equity)) / yearlyData.size) * 100
        }

        return validation.toString()
    }

}