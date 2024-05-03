package com.example.intensivecounter

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
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

        repeat(10) {
            counterPage.clickIncrement()
            counterPage.checkStateIsProcess(value = it)
            recreate()
            counterPage.checkStateIsProcess(value = it)
        }

        counterPage.checkStateIsFinish()
        recreate()
        counterPage.checkStateIsFinish()

        counterPage.clickReset()
        counterPage.checkStateIsInitial()
        recreate()
        counterPage.checkStateIsInitial()
    }
}