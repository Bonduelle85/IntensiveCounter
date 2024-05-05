package com.example.intensivecounter.presentation

import com.example.intensivecounter.views.increment.UpdateIncrement
import com.example.intensivecounter.views.reset.UpdateReset
import com.example.intensivecounter.views.text.UpdateCounter

interface UiState {

    fun update(
        updateCounter: UpdateCounter,
        updateIncrement: UpdateIncrement,
        updateReset: UpdateReset,
    )

    object Initial : UiState {
        override fun update(
            updateCounter: UpdateCounter,
            updateIncrement: UpdateIncrement,
            updateReset: UpdateReset
        ) {
            TODO("Not yet implemented")
        }
    }

    data class Process(private val counterValue: Int): UiState {
        override fun update(
            updateCounter: UpdateCounter,
            updateIncrement: UpdateIncrement,
            updateReset: UpdateReset
        ) {
            TODO("Not yet implemented")
        }
    }

    object Finish: UiState {
        override fun update(
            updateCounter: UpdateCounter,
            updateIncrement: UpdateIncrement,
            updateReset: UpdateReset
        ) {
            TODO("Not yet implemented")
        }
    }

    object Empty : UiState {
        override fun update(
            updateCounter: UpdateCounter,
            updateIncrement: UpdateIncrement,
            updateReset: UpdateReset
        ) = Unit
    }
}