package com.example.intensivecounter.views.reset

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View.BaseSavedState


class ResetSavedState : BaseSavedState {

    private lateinit var state: ResetUiState

    constructor(superState: Parcelable) : super(superState)
    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ResetUiState::class.java.classLoader,
                ResetUiState::class.java
            ) as ResetUiState
        } else {
            parcelIn.readSerializable() as ResetUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ResetUiState = state

    fun save(uiState: ResetUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ResetSavedState> {
        override fun createFromParcel(parcel: Parcel): ResetSavedState =
            ResetSavedState(parcel)

        override fun newArray(size: Int): Array<ResetSavedState?> =
            arrayOfNulls(size)
    }
}