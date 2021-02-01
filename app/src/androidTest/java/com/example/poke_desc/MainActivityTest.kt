package com.example.poke_desc

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.poke_desc.ui.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    private var mMainActivity: Activity? = null
    private var mRecyclerView: RecyclerView? = null
    private var recycleViewID: Int = R.id.recyclerViewPokemon
    private var itemCount = 0

    @Before
    fun setup() {
        mMainActivity = this.activityRule.activity
        mRecyclerView = (mMainActivity as MainActivity?)?.findViewById(recycleViewID)
        itemCount = mRecyclerView?.adapter?.itemCount ?: 0
    }

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onRecycleViewIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(
            ViewMatchers.withId(
                R.id.recyclerViewPokemon
            )
        ).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )
        Espresso.onView(
            ViewMatchers.withId(
                R.id.recyclerViewPokemon
            )
        ).check(
            ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("charizard")))
        )
    }


}