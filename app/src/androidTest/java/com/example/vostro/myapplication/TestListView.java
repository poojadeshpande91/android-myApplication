package com.example.vostro.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by vostro on 27/8/16.
 */
@RunWith(AndroidJUnit4.class)
public class TestListView {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Test
    public void findStringInListView() {
        onData(allOf(is(instanceOf(String.class)), is("List Item 18"))).perform(click());
    }
}
