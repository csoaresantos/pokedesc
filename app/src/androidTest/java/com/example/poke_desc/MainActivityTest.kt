package com.example.poke_desc

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.poke_desc.ui.adapter.PokemonAdapter
import com.example.poke_desc.ui.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onRecycleViewIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(
            withId(
                R.id.recyclerViewPokemon
            )
        ).check(
            matches(isDisplayed())
        )

        onView(
            withId(R.id.recyclerViewPokemon)
        ).check(matches(hasDescendant(withText("bulbasaur"))))
            .check(matches(hasDescendant(withText("charizard"))))

        onView(
            withId(R.id.recyclerViewPokemon)
        ).check(matches(hasDescendant(withText("bulbasaur"))))
    }

    @Test
    fun onItemPokemonNameIsClicked() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(
            withId(R.id.recyclerViewPokemon)
        ).check(matches(hasDescendant(withText("bulbasaur"))))
            .check(matches(hasDescendant(withText("charizard"))))

        onView(
            withId(R.id.recyclerViewPokemon)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<PokemonAdapter.DataViewHolder>(
                6,
                ViewActions.click()
            )
        )
    }
}