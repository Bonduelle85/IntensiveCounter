package com.example.intensivecounter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description


class TextViewColorMatcher(private val color: Int) :
    BoundedMatcher<View, TextView>(TextView::class.java) {

    constructor(colorString: String) : this(Color.parseColor(colorString))

    override fun matchesSafely(textView: TextView): Boolean {
        return (textView.currentTextColor as ColorDrawable).color == color
    }

    override fun describeTo(description: Description) {
        description.appendText("with text color: ")
    }
}

