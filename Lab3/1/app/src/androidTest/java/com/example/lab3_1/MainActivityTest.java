package com.example.lab3_1;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.init;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.release;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        init();
    }

    @Test
    public void testGerButn() {
        onView(withId(R.id.button1)).perform(click());
        intended(hasComponent(GerActivity.class.getName()));
        release();
    }


    @Test
    public void testSwitzButn() {
        onView(withId(R.id.button2)).perform(click());
        intended(hasComponent(SwitzActivity.class.getName()));
        release();


    }

    @Test
    public void testItalButn() {
        onView(withId(R.id.button3)).perform(click());
        intended(hasComponent(ItActivity.class.getName()));
        release();


    }
}