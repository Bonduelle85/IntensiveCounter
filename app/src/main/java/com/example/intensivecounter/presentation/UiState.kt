package com.example.intensivecounter.presentation

import com.example.intensivecounter.views.increment.IncrementUiState
import com.example.intensivecounter.views.increment.UpdateIncrement
import com.example.intensivecounter.views.reset.ResetUiState
import com.example.intensivecounter.views.reset.UpdateReset
import com.example.intensivecounter.views.text.CounterUiState
import com.example.intensivecounter.views.text.UpdateCounter

interface UiState {

    fun update(
        counterTextView: UpdateCounter,
        incrementButton: UpdateIncrement,
        resetButton: UpdateReset,
    )

    object Initial : UiState {
        override fun update(
            counterTextView: UpdateCounter,
            incrementButton: UpdateIncrement,
            resetButton: UpdateReset
        ) {
            counterTextView.updateUiState(CounterUiState.Initial)
            incrementButton.updateUiState(IncrementUiState.Initial)
            resetButton.updateUiState(ResetUiState.Initial)
        }
    }

    data class Process(private val counterValue: Int): UiState {
        override fun update(
            counterTextView: UpdateCounter,
            incrementButton: UpdateIncrement,
            resetButton: UpdateReset
        ) {
            counterTextView.updateUiState(CounterUiState.Process(counterValue))
            incrementButton.updateUiState(IncrementUiState.Process)
            resetButton.updateUiState(ResetUiState.Process)
        }
    }

    object Finish: UiState {
        override fun update(
            counterTextView: UpdateCounter,
            incrementButton: UpdateIncrement,
            resetButton: UpdateReset
        ) {
            counterTextView.updateUiState(CounterUiState.Finish)
            incrementButton.updateUiState(IncrementUiState.Finish)
            resetButton.updateUiState(ResetUiState.Finish)
        }
    }

    object Empty : UiState {
        override fun update(
            counterTextView: UpdateCounter,
            incrementButton: UpdateIncrement,
            resetButton: UpdateReset
        ) = Unit
    }
}