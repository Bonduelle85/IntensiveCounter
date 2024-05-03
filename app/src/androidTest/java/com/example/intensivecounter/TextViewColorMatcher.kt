package com.example.intensivecounter

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description


class TextViewColorMatcher(private val expectedId: Int) :
    BoundedMatcher<View?, TextView>(TextView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("with text color: ")
        description.appendValue(expectedId)
    }

    override fun matchesSafely(textView: TextView): Boolean {
        val colorId = ContextCompat.getColor(textView.context, expectedId)
        return textView.currentTextColor == colorId
    }
}

