package com.example.intensivecounter

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class CounterPage {

    private val rootIdMatcher: Matcher<View> = withId(R.id.rootLayout)
    private val parentLayoutMatcher: Matcher<View> = withParent(isAssignableFrom(LinearLayout::class.java))

    private val counter = CounterTextViewUi(rootIdMatcher, parentLayoutMatcher)
    private val incrementButton = IncrementButtonUi(rootIdMatcher, parentLayoutMatcher)
    private val resetButton = ResetButtonUi(rootIdMatcher, parentLayoutMatcher)

    fun checkStateIsInitial() {
        counter.checkStateIsInitial()
        incrementButton.checkStateIsInitial()
        resetButton.checkStateIsInitial()
    }


    fun checkStateIsProcess(value: Int) {
        counter.checkStateIsProcess(value = value)
        incrementButton.checkStateIsProcess()
        resetButton.checkStateIsProcess()
    }

    fun checkStateIsFinish() {
        counter.checkStateIsFinish()
        incrementButton.checkStateIsFinish()
        resetButton.checkStateIsFinish()
    }

    fun clickIncrement() {
        incrementButton.click()
    }

    fun clickReset() {
        resetButton.click()
    }
}
