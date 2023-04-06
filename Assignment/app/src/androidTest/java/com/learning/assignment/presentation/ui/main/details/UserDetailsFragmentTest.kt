package com.learning.assignment.presentation.ui.main.details

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.learning.assignment.R
import com.learning.assignment.launchFragmentInHiltContainer
import com.learning.assignment.ui.main.details.UserDetailsFragment
import com.learning.assignment.utils.FakeDataGenerator
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


@HiltAndroidTest
class UserDetailsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun check_title_and_noteId_in_detail_view() {
        val navController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<UserDetailsFragment>(Bundle().apply {
            putSerializable("user", FakeDataGenerator.getFakeUsers()[0])
        }) {
            Navigation.setViewNavController(requireView(), navController)
        }

        onView(withId(R.id.titleTv)).check(matches(withText("Fake 1")))
        onView(withId(R.id.nodeIdTv)).check(matches(withText("MDQ6VXNlcjIwNzA0Nzc3")))
    }
}