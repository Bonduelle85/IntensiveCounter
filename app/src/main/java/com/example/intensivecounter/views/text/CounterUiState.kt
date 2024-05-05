package com.example.intensivecounter.views.text


import com.example.intensivecounter.R
import java.io.Serializable

interface CounterUiState : Serializable {

    fun show(counterTextView: UpdateCounter)

    abstract class Abstract(private val counterValue: Int, private val color: Int) : CounterUiState {
        override fun show(counterTextView: UpdateCounter) {
            counterTextView.updateUi(counterValue = counterValue, colorResId = color)
        }
    }

    object Initial : Abstract(0, R.color.green)

    data class Process(private val value: Int) : Abstract(counterValue = value, R.color.black)

    object Finish : Abstract(10, R.color.red)
}