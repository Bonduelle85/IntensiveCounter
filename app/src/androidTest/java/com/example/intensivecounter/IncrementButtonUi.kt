package com.example.intensivecounter

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class IncrementButtonUi(
    rootIdMatcher: Matcher<View>,
    parentLayoutMatcher: Matcher<View>
) {

    private val interaction = Espresso.onView(
        allOf(
            withId(R.id.incrementButton),
            isAssignableFrom(AppCompatButton::class.java),
            withText(R.string.increment),
            rootIdMatcher,
            parentLayoutMatcher,
        )
    )

    fun checkStateIsInitial() {
        interaction.check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }

    fun checkStateIsProcess() {
        interaction.check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }

    fun checkStateIsFinish() {
        interaction.check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
}
