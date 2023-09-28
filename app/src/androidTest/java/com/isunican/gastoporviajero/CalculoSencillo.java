package com.isunican.gastoporviajero;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 
Instrumented test, which will execute on an Android device.*
@see <a href="http://d.android.com/tools/testing">Testing documentation</a>
*/
@RunWith(AndroidJUnit4.class)
public class CalculoSencillo {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule(MainActivity.class);


    @Test
    public void calculoTest() {
        onView(withId(R.id.etConsumo)).perform(typeText("5"));
        onView(withId(R.id.etKm)).perform(typeText("5"));
        onView(withId(R.id.etPrecio)).perform(typeText("5"));
        onView(withId(R.id.etPasajeros)).perform(typeText("5"));

        onView(withId(R.id.btnCalcular)).perform(click());

        onView(withId(R.id.tvResultado)).check(matches(withText("0.25")));


    }
}