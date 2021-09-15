package com.example.stockscreenernocompose.cases.welcomePage

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.stockscreenernocompose.R
import com.example.stockscreenernocompose.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: WelcomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeBinding.bind(view)

        initUI()
    }

    private fun initUI() {

        binding.validateButton.setOnClickListener {
            val validationResult =
                viewModel.validateSymbol(binding.tickerSymbolEditText.text.toString())

            if (validationResult == 0) {
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToResultFragment()
                findNavController().navigate(action)
            } else {
                Toast.makeText(context, getString(validationResult), Toast.LENGTH_SHORT).show()
            }
        }
    }

}