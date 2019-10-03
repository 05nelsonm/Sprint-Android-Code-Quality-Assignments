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
class TitleUITest: UITestBase() {

    companion object {
        const val TITLE_TEXT = "This Is My Title"
    }

    @Rule // JUnit test rule
    @JvmField // Allows for compatibility with kotlin
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_changeTitle_sameActivity() {
        // Setup
        onView(withId(R.id.title_input))
            .perform(typeText(TITLE_TEXT), closeSoftKeyboard())

        // Execute
        onView(withId(R.id.change_title_button)).perform(click())

        // Check
        onView(withId(R.id.title_view)).check(matches(withText(TITLE_TEXT)))
    }

    @Test
    fun b_changeTitle_sameActivity() {
        // Setup
        onView(withId(R.id.title_input))
            .perform(typeText(TITLE_TEXT), closeSoftKeyboard())

        // Execute
        onView(withId(R.id.pass_title_button)).perform(click())

        // Check
        onView(withId(R.id.show_title_view)).check(matches(withText(TITLE_TEXT)))
        viewPressBack()
        //onView(withId(R.id.title_view)).check(matches(withText(TITLE_TEXT)))
    }
}