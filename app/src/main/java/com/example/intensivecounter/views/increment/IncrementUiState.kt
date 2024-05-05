package com.example.intensivecounter.views.increment

import java.io.Serializable


interface IncrementUiState : Serializable {

    fun show(incrementButton: UpdateIncrement)

    abstract class Abstract(private val isEnabled: Boolean = true) : IncrementUiState {
        override fun show(incrementButton: UpdateIncrement) {
            incrementButton.updateUi(isEnabled = isEnabled)
        }
    }

    object Initial : Abstract()

    object Process : Abstract()

    object Finish : Abstract(isEnabled = false)
}