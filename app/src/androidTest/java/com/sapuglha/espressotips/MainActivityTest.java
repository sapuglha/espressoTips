package com.sapuglha.espressotips;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);

    @Test
    public void test_upper_empty() throws Exception {
        onView(withId(R.id.main_activity_button_upper)).perform(click());
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("")));
    }

    @Test
    public void test_upper_numbers() throws Exception {
        onView(withId(R.id.main_activity_text_input)).perform(typeText("123"));
        onView(withId(R.id.main_activity_button_upper)).perform(click());
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("123")));
    }

    @Test
    public void test_lower_abc() throws Exception  {
        onView(withId(R.id.main_activity_text_input))
                .perform(typeText("ABC"), closeSoftKeyboard());
        onView(withId(R.id.main_activity_button_lower)).perform(click());
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("abc")));

        onView(allOf(withId(android.support.design.R.id.snackbar_text),
                withText("You entered: ABC")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void test_hello_activity() throws Exception {
        onView(withId(R.id.main_activity_text_input))
                .perform(typeText("Tiago"), closeSoftKeyboard());

        onView(withId(R.id.main_activity_checkbox_new_window)).perform(click());

        onView(withId(R.id.main_activity_button_lower)).perform(click());

        intended(hasComponent(HelloActivity.class.getName()));

        onView(withId(R.id.hello_activity_text_name)).check(matches(withText("Tiago")));
    }

    @Test
    public void test_label_resist_rotation() throws Exception {
        onView(withId(R.id.main_activity_text_input)).perform(typeText("xyz"), closeSoftKeyboard());
        onView(withId(R.id.main_activity_button_upper)).perform(click());
        onView(withId(R.id.main_activity_text_output)).check(matches(withText("XYZ")));

        rotateScreen();

        onView(withId(R.id.main_activity_text_output)).check(matches(withText("XYZ")));
    }

    private void rotateScreen() {
        Context context = InstrumentationRegistry.getTargetContext();
        int orientation = context.getResources().getConfiguration().orientation;

        Activity activity = activityTestRule.getActivity();
        activity.setRequestedOrientation(
                (orientation == Configuration.ORIENTATION_PORTRAIT) ?
                        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE : ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}