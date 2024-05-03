package com.example.intensivecounter.views.text


import com.example.intensivecounter.R
import java.io.Serializable

interface CounterUiState : Serializable {

    fun show(counterTextView: UpdateCounter)

    abstract class Abstract(private val textId: Int, private val color: Int) : CounterUiState {
        override fun show(counterTextView: UpdateCounter) {
            counterTextView.updateUi(textId = textId, color = color)
        }
    }

    object Initial : Abstract(R.string.initial_value, R.color.green)

    data class Process(private val value: Int) : Abstract(textId = value, R.color.black)

    object Finish : Abstract(R.string.finish_value, R.color.red)
}