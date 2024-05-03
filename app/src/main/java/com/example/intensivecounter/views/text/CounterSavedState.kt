package com.example.intensivecounter.views.text

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View.BaseSavedState
import com.example.intensivecounter.views.increment.IncrementUiState

class CounterSavedState : BaseSavedState {

    private lateinit var state: CounterUiState

    constructor(superState: Parcelable) : super(superState)
    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                IncrementUiState::class.java.classLoader,
                IncrementUiState::class.java
            ) as CounterUiState
        } else {
            parcelIn.readSerializable() as CounterUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): CounterUiState = state

    fun save(uiState: CounterUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<CounterSavedState> {
        override fun createFromParcel(parcel: Parcel): CounterSavedState =
            CounterSavedState(parcel)

        override fun newArray(size: Int): Array<CounterSavedState?> =
            arrayOfNulls(size)
    }
}