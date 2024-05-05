package com.example.intensivecounter.views.reset

import java.io.Serializable

interface ResetUiState : Serializable {

    fun show(resetButton: UpdateReset)

    abstract class Abstract(private val isVisible: Boolean = false) : ResetUiState {
        override fun show(resetButton: UpdateReset) {
            resetButton.updateUi(isVisible = isVisible)
        }
    }

    object Initial : Abstract()

    object Process : Abstract()

    object Finish : Abstract(isVisible = true)
}