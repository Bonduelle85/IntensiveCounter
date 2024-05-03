package com.example.intensivecounter

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf


class CounterTextViewUi(
    rootIdMatcher: Matcher<View>,
    parentLayoutMatcher: Matcher<View>
) {

    private val initialValue = R.string.initial_value
    private val finishValue = R.string.finish_value

    private val red = R.color.red
    private val green = R.color.green
    private val black = R.color.black

    private val interaction = Espresso.onView(
        allOf(
            withId(R.id.counterVextView),
            isAssignableFrom(TextView::class.java),
            rootIdMatcher,
            parentLayoutMatcher,
        )
    )


    fun checkStateIsInitial() {
        interaction.check(matches(withText(initialValue)))
            .check(matches(TextViewColorMatcher(green)))
    }

    fun checkStateIsProcess(value: Int) {
        interaction.check(matches(withText(value)))
            .check(matches(TextViewColorMatcher(black)))
    }

    fun checkStateIsFinish() {
        interaction.check(matches(withText(finishValue)))
            .check(matches(TextViewColorMatcher(red)))
    }
}
