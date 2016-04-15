package edu.lclark.pokemonlistapp;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ntille on 4/12/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class InitialInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testListExists() {

        onView(withId(R.id.activity_main_pokemon_listview)).check(matches(isDisplayed()));
        onView(withText("bulbasaur")).perform(click());
//        onView(withText("bulbasaur")).check(doesNotExist());
        onView(withId(R.id.activity_pokemon_detail_imageview)).check(matches(isDisplayed()));
        onView(withText("bulbasaur")).check(matches(isDisplayed()));

        pressBack();

    }
}
