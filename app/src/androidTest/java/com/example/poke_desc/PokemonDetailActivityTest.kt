package com.example.poke_desc

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.poke_desc.ui.view.PokemonDetailActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PokemonDetailActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(PokemonDetailActivity::class.java, false, false)

    @Before
    fun setup() {
        val intent = Intent()
        intent.putExtra("EXTRA_POKEMON", 1)
        activityRule.launchActivity(intent)
    }

    @Test
    fun onLoadDetailValidPokemonName() {
        onView(withId(R.id.pokemonDetailLayout))
            .check(matches(hasDescendant(withText("bulbasaur"))))
    }

    @Test
    fun onLoadDetailValidPokemonStatAttackAttributes() {
        onView(withId(R.id.recycleViewStats))
            .check(matches(hasDescendant(withText("hp"))))
            .check(matches(hasDescendant(withText("45"))))

            .check(matches(hasDescendant(withText("attack"))))
            .check(matches(hasDescendant(withText("45"))))

            .check(matches(hasDescendant(withText("defense"))))
            .check(matches(hasDescendant(withText("49"))))

            .check(matches(hasDescendant(withText("special-attack"))))
            .check(matches(hasDescendant(withText("65"))))

            .check(matches(hasDescendant(withText("special-defense"))))
            .check(matches(hasDescendant(withText("65"))))

            .check(matches(hasDescendant(withText("speed"))))
            .check(matches(hasDescendant(withText("45"))))
    }
}