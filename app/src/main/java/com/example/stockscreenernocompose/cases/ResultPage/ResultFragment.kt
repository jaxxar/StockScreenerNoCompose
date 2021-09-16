package com.example.stockscreenernocompose.cases.ResultPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

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
        binding.apply {
            backButton.setOnClickListener {
                val action = ResultFragmentDirections.actionResultFragmentToWelcomeFragment()
                findNavController().navigate(action)
            }
            companyName.text = args.stockDetails.name
            stockMarker.text = args.stockDetails.exchangeCode + ":"
            companyTicker.text = args.stockDetails.ticker
            descriptionText.text = args.stockDetails.description
        }
    }

}