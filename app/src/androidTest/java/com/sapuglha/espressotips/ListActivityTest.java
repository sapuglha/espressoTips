package com.sapuglha.espressotips;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class ListActivityTest {

    @Rule
    public IntentsTestRule<ListActivity> activityTestRule =
            new IntentsTestRule<>(ListActivity.class, true, true);

    @Test
    public void test_item_4_visible() throws Exception {
        onView(withText("Item 4")).check(matches(isDisplayed()));
    }

    @Test
    public void test_item_9_visible() throws Exception {
        onView(withText("Item 9")).check(matches(isDisplayed()));
    }

    @Test
    public void test_item_9_data_is_visible() throws Exception {
        // https://google.github.io/android-testing-support-library/docs/espresso/lists/
        onData(is("Item 9")).check(matches(isDisplayed()));
    }
}
