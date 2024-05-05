package com.example.intensivecounter

import com.example.intensivecounter.data.Repository
import com.example.intensivecounter.presentation.CounterViewModel
import com.example.intensivecounter.presentation.UiState
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class CounterViewModelTest {

    private lateinit var viewModel: CounterViewModel
    private lateinit var repository: FakeRepository

    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = CounterViewModel(
            repository = repository
        )
    }

    @Test
    fun testCase() {
        var actualUiState: UiState = viewModel.init()
        var expectedUiState: UiState = UiState.Initial
        assertEquals(expectedUiState, actualUiState)

        repeat(9) {
            actualUiState = viewModel.increment()
            expectedUiState = UiState.Process(it + 1)
            assertEquals(expectedUiState, actualUiState)
        }

        actualUiState = viewModel.increment()
        expectedUiState = UiState.Finish
        assertEquals(actualUiState , expectedUiState)

        actualUiState = viewModel.reset()
        expectedUiState = UiState.Initial
        assertEquals(actualUiState, expectedUiState)
    }
}

class FakeRepository: Repository {

    private var counter: Int = 0

    override fun getCounter(): Int = counter

    override fun isMax(): Boolean = counter == 10

    override fun increment() {
        counter++
    }

    override fun reset() {
        counter = 0
    }
}