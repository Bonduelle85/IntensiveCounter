package com.example.intensivecounter.views.increment

import java.io.Serializable


interface IncrementUiState : Serializable {

    fun show(incrementButton: UpdateIncrement)

    abstract class Abstract(private val isEnabled: Boolean) : IncrementUiState {
        override fun show(incrementButton: UpdateIncrement) {
            incrementButton.updateUi(isEnable = isEnabled)
        }
    }

    object Initial : Abstract(isEnabled = true)

    object Process : Abstract(isEnabled = true)

    object Finish : Abstract(isEnabled = false)
}