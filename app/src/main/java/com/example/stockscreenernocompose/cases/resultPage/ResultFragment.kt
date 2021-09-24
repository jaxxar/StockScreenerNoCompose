package com.example.stockscreenernocompose.cases.resultPage

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var binding: FragmentResultBinding
    private val viewModel: ResultViewModel by viewModels()
    private val args: ResultFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        initUI()
    }

    private fun initUI() {
        val formatter = DecimalFormat("#,###.00")
        binding.apply {
            backButton.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToWelcomeFragment()
                findNavController().navigate(action)
            }
            companyName.text = args.stockDetails.name
            stockMarker.text = args.stockDetails.exchangeCode + ":"
            companyTicker.text = args.stockDetails.ticker
            descriptionText.text = args.stockDetails.description
            marketCapText.text =
                getString(
                    R.string.market_cap,
                    formatter.format(args.listStockDailyData.last().marketCap)
                )
            enterpriseValText.text =
                getString(
                    R.string.enterprise_val,
                    formatter.format(args.listStockDailyData.last().enterpriseVal)
                )
            peRatioText.text = getString(
                R.string.peRatio,
                formatter.format(args.listStockDailyData.last().peRatio)
            )

            if (viewModel.validatePE(args.listStockDailyData.last().peRatio!!)) {
                peResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                peResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            if (viewModel.validatePB(args.listStockDailyData.last().pbRatio!!)) {
                pbRatioResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                pbRatioResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            if (viewModel.validatePEG(args.listStockDailyData.last().trailingPEG1Y!!.toFloat())) {
                trailingPEG1YResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                trailingPEG1YResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            val freeCashFlowResult = viewModel.validateFreeCashFlow(args.statementData)
            if (freeCashFlowResult.resultBoolean) {
                freeCashFlowResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                freeCashFlowResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }
            freeCashFlowText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    freeCashFlowResult.resultString
                )
                findNavController().navigate(action)
            }

            val totalSharesResult = viewModel.validateTotalShares(args.statementData)
            if (totalSharesResult.resultBoolean) {
                sharesResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                sharesResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            sharesText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    totalSharesResult.resultString
                )
                findNavController().navigate(action)
            }

            val revenueResult = viewModel.validateRevenue(args.statementData)
            if (revenueResult.resultBoolean) {
                revenueResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                revenueResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            revenueText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    revenueResult.resultString
                )
                findNavController().navigate(action)
            }

            val netIncomeResult = viewModel.validateNetIncome(args.statementData)
            if (netIncomeResult.resultBoolean) {
                netIncomeResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                netIncomeResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            netIncomeText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    netIncomeResult.resultString
                )
                findNavController().navigate(action)
            }

            val rOICResult = viewModel.validateROIC(args.statementData)
            if (rOICResult.resultBoolean) {
                roicResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                roicResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            roicText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    rOICResult.resultString
                )
                findNavController().navigate(action)
            }

            val liabilitiesResult = viewModel.validateLiabilities(args.statementData)
            if (liabilitiesResult.resultBoolean) {
                longTermLiabilitiesResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                longTermLiabilitiesResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            longTermLiabilitiesText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    resources.getString(
                        R.string.liabilities_repay,
                        liabilitiesResult.resultString
                    )
                )
                findNavController().navigate(action)
            }

            val priceToFreeCashFlowResult = viewModel.validatePriceToAverageFreeCashFlow(
                args.statementData,
                args.listStockDailyData.last()
            )
            if (priceToFreeCashFlowResult.resultBoolean) {
                priceToFreeCashFlowResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_check_circle,
                        null
                    )
                )
            } else {
                priceToFreeCashFlowResultBox.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_remove_circle,
                        null
                    )
                )
            }

            priceToFreeCashFlowText.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToDialogFragment(
                    priceToFreeCashFlowResult.resultString
                )
                findNavController().navigate(action)
            }

            pbRatioText.text = getString(
                R.string.pbRatio,
                formatter.format(args.listStockDailyData.last().pbRatio)
            )
            trailingPEG1YText.text =
                getString(R.string.trailingPEG1Y, args.listStockDailyData.last().trailingPEG1Y)
        }
    }

}