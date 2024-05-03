package com.example.intensivecounter

import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsNot.not

class ResetButtonUi(
    rootIdMatcher: Matcher<View>,
    parentLayoutMatcher: Matcher<View>
) {

    private val interaction = onView(
        allOf(
            ViewMatchers.withId(R.id.resetButton),
            ViewMatchers.isAssignableFrom(Button::class.java),
            rootIdMatcher,
            parentLayoutMatcher,
        )
    )

    fun checkStateIsInitial() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun checkStateIsProcess() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun checkStateIsFinish() {
        interaction.check(matches(isDisplayed()))
    }

    fun clickReset() {
        interaction.perform(click())
    }
}
