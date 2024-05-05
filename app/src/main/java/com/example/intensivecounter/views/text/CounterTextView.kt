package com.example.intensivecounter.views.text

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class CounterTextView : AppCompatTextView, UpdateCounter {

    private lateinit var uiState: CounterUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )


    override fun updateUiState(outer: CounterUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun updateUi(counterValue: Int, colorResId: Int) {
        this.setText(counterValue.toString())
        this.setTextColor(ContextCompat.getColor(context, colorResId))
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let { superState ->
            val state = CounterSavedState(superState)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CounterSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateCounter {
    fun updateUiState(outer: CounterUiState)
    fun updateUi(counterValue: Int, @ColorRes colorResId: Int)
}