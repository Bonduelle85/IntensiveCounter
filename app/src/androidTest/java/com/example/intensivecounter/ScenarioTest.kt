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
        counterPage.checkStateIsInitial(value = 0)
        recreate()
        counterPage.checkStateIsInitial(value = 0)

        counterPage.clickIncrement()
        counterPage.checkStateIsProcess(value = 1)
        recreate()
        counterPage.checkStateIsProcess(value = 1)

        repeat(9) {
            counterPage.clickIncrement()
        }
        counterPage.checkStateIsFinish(value = 10)
        recreate()
        counterPage.checkStateIsFinish(value = 10)

        counterPage.clickReset()
        counterPage.checkStateIsInitial(value = 0)
        recreate()
        counterPage.checkStateIsInitial(value = 0)
    }
}