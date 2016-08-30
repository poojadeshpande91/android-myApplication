package com.example.vostro.myapplication;

import android.support.test.espresso.contrib.DrawerActions;
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
public class TestMainActivity {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Test
    public void openListView() {
        DrawerActions.openDrawer(R.id.drawer_layout);
        onData(allOf(is(instanceOf(String.class)), is("List View"))).perform(click());
    }

    @Test
    public void openRecyclerView() {
        DrawerActions.openDrawer(R.id.drawer_layout);
        onData(allOf(is(instanceOf(String.class)), is("Recycler View"))).perform(click());
    }
}
