package com.example.intensivecounter.views.reset

import java.io.Serializable

interface ResetUiState : Serializable {

    fun show(resetButton: UpdateReset)

    abstract class Abstract(private val isVisible: Boolean) : ResetUiState {
        override fun show(resetButton: UpdateReset) {
            resetButton.updateUi(visibility = isVisible)
        }
    }

    object Initial : Abstract(isVisible = false)

    object Process : Abstract(isVisible = false)

    object Finish : Abstract(isVisible = true)
}