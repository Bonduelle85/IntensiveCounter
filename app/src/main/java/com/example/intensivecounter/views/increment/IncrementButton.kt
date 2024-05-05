package com.example.intensivecounter.views.increment

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class IncrementButton : AppCompatButton, UpdateIncrement {

    private lateinit var uiState: IncrementUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: IncrementUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun updateUi(isEnabled: Boolean) {
        this.isEnabled = isEnabled
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let { superState ->
            val state = IncrementSavedState(superState)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as IncrementSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateIncrement {
    fun updateUiState(outer: IncrementUiState)
    fun updateUi(isEnabled: Boolean)
}