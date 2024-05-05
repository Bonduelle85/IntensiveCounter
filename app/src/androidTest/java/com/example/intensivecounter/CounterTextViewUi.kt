package com.example.intensivecounter

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
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

    private val interaction = Espresso.onView(
        allOf(
            withId(R.id.counterTextView),
            isAssignableFrom(TextView::class.java),
            rootIdMatcher,
            parentLayoutMatcher,
        )
    )


    fun checkStateIsInitial() {
        val initialValue = 0
        val green = R.color.green
        interaction.check(matches(withText(initialValue)))
            .check(matches(TextViewColorMatcher(green)))
    }

    fun checkStateIsProcess(value: Int) {
        val black = R.color.black
        interaction.check(matches(withText(value.toString())))
            .check(matches(TextViewColorMatcher(black)))
    }

    fun checkStateIsFinish() {
        val finishValue = 10
        val red = R.color.red
        interaction.check(matches(withText(finishValue)))
            .check(matches(TextViewColorMatcher(red)))
    }
}
