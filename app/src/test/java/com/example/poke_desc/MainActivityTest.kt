package com.example.poke_desc

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.poke_desc.ui.view.MainActivity
import com.example.poke_desc.ui.viewmodel.PokemonViewModel
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin

@RunWith(AndroidJUnit4::class)
class SomeActivityTest : KoinTestApp() {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java, false, false)


    lateinit var mockVm: PokemonViewModel


    @After
    fun cleanUp() {
        stopKoin()
    }

    @Test
    fun shouldHaveTextViewWithMessage() {
        // 2. start activity
        rule.launchActivity(null)

//        Espresso.onView(ViewMatchers.withId(R.id.progressBar)).check(ArgumentMatchers.matches ())
//        // 3. test
//        onView(withId(R.id.tv_message))
//            .check(matches(isDisplayed()))
//
//        onView(withId(R.id.tv_message))
//            .check(matches(withText(message)))
    }
}