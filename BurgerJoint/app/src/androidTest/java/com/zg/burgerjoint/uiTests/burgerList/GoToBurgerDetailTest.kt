package com.zg.burgerjoint.uiTests.burgerList

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.activities.MainActivity
import com.zg.burgerjoint.viewholders.BurgerViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.zg.burgerjoint.R


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToBurgerDetailTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun init(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurgerItem_navigateToBurgerDetail(){
        onView(withId(R.id.rvBurgerList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<BurgerViewHolder>(0, click()))

        onView(withId(R.id.favBurgerDetail))
            .check(matches(isDisplayed()))
    }
}