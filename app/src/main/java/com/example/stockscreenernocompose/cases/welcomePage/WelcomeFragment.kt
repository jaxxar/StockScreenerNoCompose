package com.example.stockscreenernocompose.cases.welcomePage

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: WelcomeViewModel by viewModels()
    private var doubleBackToExitPressesOnce = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeBinding.bind(view)

        initUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (doubleBackToExitPressesOnce) {
                requireActivity().finish()
            }
            doubleBackToExitPressesOnce = true
            Toast.makeText(context, R.string.backToExit, Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed(
                { doubleBackToExitPressesOnce = false },
                2000
            )
        }
    }

    private fun beginLoading() {
        binding.loadingLayout.visibility = View.VISIBLE
        binding.validateButton.isClickable = false
    }

    private fun stopLoading() {
        binding.loadingLayout.visibility = View.GONE
        binding.validateButton.isClickable = true
    }

    private fun initUI() {

        binding.validateButton.setOnClickListener {
            beginLoading()
            val validationResult =
                viewModel.validateSymbol(binding.tickerSymbolEditText.text.toString())
            CoroutineScope(Dispatchers.IO).launch {
                if (validationResult == 0) {
                    val result =
                        viewModel.getStockData(binding.tickerSymbolEditText.text.toString())
                    if (result.requestResult) {
                        CoroutineScope(Dispatchers.Main).launch {
                            val action =
                                WelcomeFragmentDirections.actionWelcomeFragmentToResultFragment(
                                    result
                                )
                            stopLoading()
                            findNavController().navigate(action)
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            stopLoading()
                            Toast.makeText(
                                context,
                                result.requestCode.toString(),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        stopLoading()
                        Toast.makeText(context, getString(validationResult), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}