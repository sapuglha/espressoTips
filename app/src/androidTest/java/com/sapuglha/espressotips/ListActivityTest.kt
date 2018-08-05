package com.sapuglha.espressotips

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListActivityTest {

    @Rule
    var activityTestRule = IntentsTestRule(ListActivity::class.java, true, true)

    @Test
    fun testItem4Visible() {
        onView(withText("Item 4")).check(matches(isDisplayed()))
    }

    @Test
    fun testItem9Visible() {
        onView(withText("Item 9")).check(matches(isDisplayed()))
    }

    @Test
    fun testItem9DataIsVisible() {
        // https://google.github.io/android-testing-support-library/docs/espresso/lists/
        onData(`is`("Item 9")).check(matches(isDisplayed()))
    }
}
