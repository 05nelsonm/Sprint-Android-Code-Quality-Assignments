package com.lambdaschool.helloespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
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
class ValidationTests: UITestBase() {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun changeEditText_validEmails() {
        // Setup
        val validEmails = listOf(
            "valid@protonmail.com",
            "test@protonmail.com",
            "test@pm.me"
        )

        // Perform
        validEmails.forEach { email ->
            onView(withId(R.id.email_input)).perform(
                clearText(),
                typeText(email),
                closeSoftKeyboard()
            )
        }


        // Check
        onView(withId(R.id.check_email_box)).check(matches(isChecked()))
    }

    @Test
    fun changeEditText_invalidEmails() {
        // Setup
        val invalidEmails = listOf(
            "testprotonmail.com",
            "test@pm."
        )

        // Perform
        invalidEmails.forEach { email ->
            onView(withId(R.id.email_input)).perform(
                *commonViewAction(email)
                /*clearText(),
                typeText(email),
                closeSoftKeyboard()*/
            )
        }


        // Check
        onView(withId(R.id.check_email_box)).check(matches(isNotChecked()))
    }

    @Test
    fun changeEditText_ValidPasswords() {
        val validPasswords = listOf(
            "Adj$2k-29!",
            "029njnJhj3bj-JKJ$()"
        )

        validPasswords.forEach { password ->
            onView(withId(R.id.password_input)).perform(
                clearText(),
                typeText(password),
                closeSoftKeyboard()
            )
        }

        onView(withId(R.id.check_password_box)).check(matches(isChecked()))
    }

}