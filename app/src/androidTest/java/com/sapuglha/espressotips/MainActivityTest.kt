package com.sapuglha.espressotips

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    var activityTestRule = IntentsTestRule(MainActivity::class.java, true, true)

    @Test
    fun testUpperEmpty() {
        onView(withId(R.id.main_activity_button_upper)).perform(click())
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("")))
    }

    @Test
    fun testUpperNumbers() {
        onView(withId(R.id.main_activity_text_input)).perform(typeText("123"))
        onView(withId(R.id.main_activity_button_upper)).perform(click())
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("123")))
    }

    @Test
    fun testLowerAbc() {
        onView(withId(R.id.main_activity_text_input))
                .perform(typeText("ABC"), closeSoftKeyboard())
        onView(withId(R.id.main_activity_button_lower)).perform(click())
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("abc")))

        onView(allOf<View>(withId(android.support.design.R.id.snackbar_text),
                withText("You entered: ABC")))
                .check(matches(isDisplayed()))
    }

    @Test
    fun testHelloActivity() {
        onView(withId(R.id.main_activity_text_input))
                .perform(typeText("Tiago"), closeSoftKeyboard())

        onView(withId(R.id.main_activity_checkbox_new_window)).perform(click())

        onView(withId(R.id.main_activity_button_lower)).perform(click())

        intended(hasComponent(HelloActivity::class.java.name))

        onView(withId(R.id.hello_activity_text_name)).check(matches(withText("Tiago")))
    }

    @Test
    fun testLabelResistRotation() {
        onView(withId(R.id.main_activity_text_input)).perform(typeText("xyz"), closeSoftKeyboard())
        onView(withId(R.id.main_activity_button_upper)).perform(click())
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("XYZ")))

        rotateScreen()

        onView(withId(R.id.main_activity_text_output)).check(matches(withText("XYZ")))
    }

    private fun rotateScreen() {
        val context = InstrumentationRegistry.getTargetContext()
        val orientation = context.resources.configuration.orientation

        val activity = activityTestRule.activity
        activity.requestedOrientation = if (orientation == Configuration.ORIENTATION_PORTRAIT)
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        else
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

}