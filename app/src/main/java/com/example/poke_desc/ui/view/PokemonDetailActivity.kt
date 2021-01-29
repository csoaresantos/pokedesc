package com.example.poke_desc.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poke_desc.R
import com.example.poke_desc.databinding.ActivityPokemonDetailBinding
import com.example.poke_desc.ui.viewmodel.PokemonDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.data.model.Stat
import com.example.poke_desc.ui.adapter.PokemonAdapter
import com.example.poke_desc.ui.adapter.PokemonStatAdapter
import com.example.poke_desc.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pokemon_detail.*


class PokemonDetailActivity :AppCompatActivity() {
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModel()
    private var pokemonId: Int = 0
    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var statsAdapter: PokemonStatAdapter


    companion object {
        val SPAN_COUNT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon_detail)
        binding.lifecycleOwner = this
        //binding.pokemonModel = pokemonDetailViewModel.pokemon.value as Pokemon
        setupObservers()
        setupUI()
        pokemonId = intent.getIntExtra("EXTRA_POKEMON", 0)
        pokemonDetailViewModel.getPokemonDetail(pokemonId)

    }

    private fun setupUI() {
        recycleViewStats.layoutManager = GridLayoutManager(this, PokemonDetailActivity.SPAN_COUNT)
        statsAdapter = PokemonStatAdapter(arrayListOf())

        recycleViewStats.adapter = statsAdapter
    }

    private fun setupObservers() {
        pokemonDetailViewModel.pokemon.observe(this, {
            when(it.status) {
                Status.SUCCESS -> {
                    binding.pokemonModel = it.data
                    binding.executePendingBindings()
                    it.data?.stats?.let { it1 -> renderStats(it1) }
                }
            }
        })
    }

    private fun renderStats(stats: List<Stat>) {
        statsAdapter.addData(stats)
        statsAdapter.notifyDataSetChanged()
    }
}

