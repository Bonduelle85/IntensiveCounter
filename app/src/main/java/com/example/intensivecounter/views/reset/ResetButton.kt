package com.example.intensivecounter.views.reset

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class ResetButton : AppCompatButton, UpdateReset {

    private lateinit var uiState: ResetUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: ResetUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun updateUi(isEnable: Boolean) {
        this.isEnabled = isEnable
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let { superState ->
            val state = ResetSavedState(superState)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ResetSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateReset {
    fun updateUiState(outer: ResetUiState)
    fun updateUi(visibility: Boolean)
}
