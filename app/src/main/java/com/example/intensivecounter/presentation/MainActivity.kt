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

        binding.incrementButton.setOnClickListener {
            uiState = viewModel.increment()
            uiState.update(
                updateCounter = binding.counterTextView,
                updateIncrement = binding.incrementButton,
                updateReset = binding.resetButton
            )
        }

        binding.resetButton.setOnClickListener {
            uiState = viewModel.reset()
            uiState.update(
                updateCounter = binding.counterTextView,
                updateIncrement = binding.incrementButton,
                updateReset = binding.resetButton
            )
        }

        viewModel.init()
        uiState.update(
            updateCounter = binding.counterTextView,
            updateIncrement = binding.incrementButton,
            updateReset = binding.resetButton
        )
    }
}