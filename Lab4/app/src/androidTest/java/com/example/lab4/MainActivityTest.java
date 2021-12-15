package com.example.lab4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.intent.Intents.init;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.release;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;
import android.widget.SeekBar;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        Intents.init();
    }

    @Test
    public void onTask1Cick() throws InterruptedException {
        onView(withId(R.id.button1)).perform(click());
        intended(hasComponent(Task1.class.getName()));
        Thread.sleep(3000);
        Intents.release();
    }


    @Test
    public void onTask2Cick() throws InterruptedException {
        onView(withId(R.id.button2)).perform(click());
        intended(hasComponent(Task2.class.getName()));
        Thread.sleep(3000);
        Intents.release();
    }

    @Test
    public void onTask3Cick() throws InterruptedException {
        onView(withId(R.id.button3)).perform(click());
        intended(hasComponent(Task3.class.getName()));
        onView(withId(R.id.constr_lay)).perform(scrollTo());
        Thread.sleep(3000);
        Intents.release();
    }

    @Test
    public void onTask4Cick() throws InterruptedException {
        onView(withId(R.id.button4)).perform(click());
        intended(hasComponent(Task4.class.getName()));
        onView(withId(R.id.constr)).perform(scrollTo());
        onView(withId(R.id.seekBar)).perform(setProgress(50));
        Thread.sleep(3000);
        Intents.release();
    }

    @Test
    public void onTask5Cick() throws InterruptedException {
        onView(withId(R.id.button5)).perform(click());
        intended(hasComponent(Task5.class.getName()));
        onView(withId(R.id.radioButton6)).perform(click());
        onView(withId(R.id.radioButton7)).perform(click());
        onView(withId(R.id.radioButton8)).perform(click());
        onView(withId(R.id.radioButton10)).perform(click());
        onView(withId(R.id.radioButton9)).perform(click());
        onView(withId(R.id.radioButton11)).perform(click());
        Thread.sleep(3000);
        Intents.release();
    }

    @Test
    public void onTask6Cick() throws InterruptedException {
        onView(withId(R.id.button6)).perform(click());
        intended(hasComponent(Task6.class.getName()));
        onView(withId(R.id.seekBar2)).perform(setProgress(8));
        Thread.sleep(3000);
        Intents.release();
    }

    public static ViewAction setProgress(final int progress) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                SeekBar seekBar = (SeekBar) view;
                seekBar.setProgress(progress);
            }
            @Override
            public String getDescription() {
                return "Set a progress on a SeekBar";
            }
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(SeekBar.class);
            }
        };
    }
}