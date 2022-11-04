package com.zg.burgerjoint.uiTests.burgerList

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.zg.burgerjoint.activities.MainActivity
import com.zg.burgerjoint.uiTests.utils.first
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.zg.burgerjoint.R
import org.junit.Rule


@RunWith(AndroidJUnit4ClassRunner::class)
class AddToCartTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

//    @get:Rule `
//    var mRuntimePermissionRule = GrantPermissionRule.grant(android.Manifest.permission.CAMERA)

    @Before
    fun init(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun clickAddToCart_addBurgerInCart(){
        onView(first(withId(R.id.btnAddToCart)))
            .perform(click())

        onView(withId(R.id.tvCartCount))
            .check(matches(withText("1")))
    }

//    @Test
//    fun openCamera(){
//
//        intending(toPackage("com.android.camera2"))
//
//
//    }
}