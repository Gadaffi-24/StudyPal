package com.example.quizzymcquizface

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test for MainActivity.
 * Verifies that UI elements load correctly and navigation to FlashcardActivity works.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testWelcomeMessage_isDisplayed() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Check if the welcome message is visible
        onView(withId(R.id.welcomeMessage))
            .check(matches(isDisplayed()))
            .check(matches(withText("Welcome to the History Quiz App")))
    }

    @Test
    fun testStartButton_navigatesToFlashcardActivity() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Click the start button
        onView(withId(R.id.startButton)).perform(click())

        // Check if question screen appears (assumes first question is visible)
        onView(withId(R.id.questionText))
            .check(matches(isDisplayed()))
    }
}
