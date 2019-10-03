package com.lambdaschool.helloespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TitleUITest {

    @Rule // JUnit test rule
    @JvmField // Allows for compatibility with kotlin
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_changeTitle_sameActivity() {
        // Setup
        val titleText = "This Is My Title"
        onView(withId(R.id.title_input))
            .perform(typeText(titleText), closeSoftKeyboard())

        // Execute
        onView(withId(R.id.change_title_button)).perform(click())

        // Check
        onView(withId(R.id.title_view)).check(matches(withText(titleText)))
    }
}