package com.example.intensivecounter.presentation

import com.example.intensivecounter.data.Repository

class CounterViewModel(
    private val repository: Repository
) {

    fun init(isFirstTime: Boolean = true): UiState {
        return if (isFirstTime)
            UiState.Initial
        else
            UiState.Empty
    }

    fun increment(): UiState {
        repository.increment()
        return if (repository.isMax())
            UiState.Finish
        else
            UiState.Process(repository.getCounter())
    }

    fun reset(): UiState {
        return UiState.Initial
    }

}