package com.example.intensivecounter

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.intensivecounter.presentation.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScenarioTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private fun recreate(){
        activityScenarioRule.scenario.recreate()
    }

    /**
     * TestCase
     *
     * 1) Состояние Initial
     * 2) Нажать на increment (состояние “process”)
     * 3) Нажать на increment 9 раз (состояние “finish”)
     * 4) Нажать на reset (состояние “initial”)
     */
    @Test
    fun testCase() {
        val counterPage = CounterPage()
        counterPage.checkStateIsInitial()
        recreate()
        counterPage.checkStateIsInitial()

        repeat(9) {
            counterPage.clickIncrement()
            counterPage.checkStateIsProcess(value = it + 1)
            recreate()
            counterPage.checkStateIsProcess(value = it + 1)
        }

        counterPage.clickIncrement()
        counterPage.checkStateIsFinish()
        recreate()
        counterPage.checkStateIsFinish()

        counterPage.clickReset()
        counterPage.checkStateIsInitial()
        recreate()
        counterPage.checkStateIsInitial()
    }
}