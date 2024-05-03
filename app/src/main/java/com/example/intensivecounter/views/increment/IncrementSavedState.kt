package com.example.intensivecounter.views.increment

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View.BaseSavedState

class IncrementSavedState : BaseSavedState {

    private lateinit var state: IncrementUiState

    constructor(superState: Parcelable) : super(superState)
    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                IncrementUiState::class.java.classLoader,
                IncrementUiState::class.java
            ) as IncrementUiState
        } else {
            parcelIn.readSerializable() as IncrementUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): IncrementUiState = state

    fun save(uiState: IncrementUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<IncrementSavedState> {
        override fun createFromParcel(parcel: Parcel): IncrementSavedState =
            IncrementSavedState(parcel)

        override fun newArray(size: Int): Array<IncrementSavedState?> =
            arrayOfNulls(size)
    }
}
