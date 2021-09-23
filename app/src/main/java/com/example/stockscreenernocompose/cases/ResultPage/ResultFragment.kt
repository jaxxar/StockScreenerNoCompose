package com.example.stockscreenernocompose.cases.ResultPage

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

            if (viewModel.validateFreeCashFlow(args.statementData)) {
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
                    viewModel.returnFreeCashFlow(args.statementData)
                )
                findNavController().navigate(action)
            }

            if (viewModel.validateTotalShares(args.statementData)) {
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
                    viewModel.returnTotalShares(args.statementData)
                )
                findNavController().navigate(action)
            }

            if (viewModel.validateRevenue(args.statementData)) {
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
                    viewModel.returnRevenue(args.statementData)
                )
                findNavController().navigate(action)
            }

            if (viewModel.validateNetIncome(args.statementData)) {
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
                    viewModel.returnNetIncome(args.statementData)
                )
                findNavController().navigate(action)
            }

            if (viewModel.validateROIC(args.statementData)) {
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
                    viewModel.returnROIC(args.statementData)
                )
                findNavController().navigate(action)
            }

            if (viewModel.validateLiabilities(args.statementData)) {
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
                        viewModel.returnLiabilities(args.statementData)
                    )
                )
                findNavController().navigate(action)
            }

            if (viewModel.validatePriceToAverageFreeCashFlow(
                    args.statementData,
                    args.listStockDailyData.last()
                )
            ) {
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
                    viewModel.returnPriceToAverageFreeCashFlow(
                        args.statementData,
                        args.listStockDailyData.last()
                    )
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