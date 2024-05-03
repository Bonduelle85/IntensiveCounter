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

    private val initialValue = R.string.initial_value
    private val finishValue = R.string.finish_value

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
    }

    fun checkStateIsProcess(value: Int) {
        interaction.check(matches(withText(value)))
    }

    fun checkStateIsFinish() {
        interaction.check(matches(withText(finishValue)))
    }
}
