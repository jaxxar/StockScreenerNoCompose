package com.example.stockscreenernocompose.cases.resultPage

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            val action = ResultFragmentDirections.actionResultFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }
    }


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
            companyName.text = args.result.domainStockDetailsData.name
            stockMarker.text = args.result.domainStockDetailsData.exchangeCode + ":"
            companyTicker.text = args.result.domainStockDetailsData.ticker
            descriptionText.text = args.result.domainStockDetailsData.description
            marketCapText.text =
                getString(
                    R.string.market_cap,
                    formatter.format(args.result.domainStockDailyData.last().marketCap)
                )
            enterpriseValText.text =
                getString(
                    R.string.enterprise_val,
                    formatter.format(args.result.domainStockDailyData.last().enterpriseVal)
                )
            peRatioText.text = getString(
                R.string.peRatio,
                formatter.format(args.result.domainStockDailyData.last().peRatio)
            )

            if (viewModel.validatePE(args.result.domainStockDailyData.last().peRatio!!)) {
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

            if (viewModel.validatePB(args.result.domainStockDailyData.last().pbRatio!!)) {
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

            if (viewModel.validatePEG(args.result.domainStockDailyData.last().trailingPEG1Y!!.toFloat())) {
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

            val freeCashFlowResult =
                viewModel.validateFreeCashFlow(args.result.domainStockStatementsData)
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

            val totalSharesResult =
                viewModel.validateTotalShares(args.result.domainStockStatementsData)
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

            val revenueResult = viewModel.validateRevenue(args.result.domainStockStatementsData)
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

            val netIncomeResult = viewModel.validateNetIncome(args.result.domainStockStatementsData)
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

            val rOICResult = viewModel.validateROIC(args.result.domainStockStatementsData)
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

            val liabilitiesResult =
                viewModel.validateLiabilities(args.result.domainStockStatementsData)
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
                args.result.domainStockStatementsData,
                args.result.domainStockDailyData.last()
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
                formatter.format(args.result.domainStockDailyData.last().pbRatio)
            )
            trailingPEG1YText.text =
                getString(
                    R.string.trailingPEG1Y,
                    args.result.domainStockDailyData.last().trailingPEG1Y
                )
        }
    }

}