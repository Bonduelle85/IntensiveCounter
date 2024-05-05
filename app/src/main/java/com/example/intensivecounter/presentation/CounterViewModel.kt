package com.example.intensivecounter.presentation

import com.example.intensivecounter.data.Repository

class CounterViewModel(
    private val repository: Repository
) {

    fun init(): UiState {
        return UiState.Initial
    }

    fun increment(): UiState {
        repository.increment()
        return if (repository.getCounter() == 10)
            UiState.Finish
        else
            UiState.Process(repository.getCounter())
    }

    fun reset(): UiState {
        return UiState.Initial
    }

}