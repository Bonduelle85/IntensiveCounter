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

    private lateinit var actualUiState: UiState
    private  lateinit var expectedUiState: UiState

    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = CounterViewModel(
            repository = repository
        )
    }

    @Test
    fun testCase1() {
        actualUiState = viewModel.init(true)
        expectedUiState = UiState.Initial
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

    @Test
    fun testCase2() {
        actualUiState = viewModel.init(true)
        expectedUiState = UiState.Initial
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.init(false)
        expectedUiState = UiState.Empty
        assertEquals(expectedUiState, actualUiState)
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