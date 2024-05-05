package com.example.intensivecounter.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intensivecounter.CounterApp
import com.example.intensivecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState
        val viewModel = (application as CounterApp).viewModel

        val showUi: () -> Unit = {
            uiState.update(
                counterTextView = binding.counterTextView,
                incrementButton = binding.incrementButton,
                resetButton = binding.resetButton
            )
        }

        binding.incrementButton.setOnClickListener {
            uiState = viewModel.increment()
            showUi.invoke()
        }

        binding.resetButton.setOnClickListener {
            uiState = viewModel.reset()
            showUi.invoke()
        }

        uiState = viewModel.init(savedInstanceState == null)
        showUi.invoke()
    }
}