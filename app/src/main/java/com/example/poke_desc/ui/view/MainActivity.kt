package com.example.poke_desc.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poke_desc.R
import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.ui.adapter.PokemonAdapter
import com.example.poke_desc.ui.viewmodel.PokemonViewModel
import com.example.poke_desc.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val pokemonViewModel: PokemonViewModel by viewModel()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        setupObservers()
        addScrollerListener()
    }

    private fun setupUI() {
        recyclerViewPokemon.layoutManager = GridLayoutManager(this, 2)
        pokemonAdapter = PokemonAdapter(arrayListOf(), pokemonViewModel)

        recyclerViewPokemon.adapter = pokemonAdapter
    }

    private fun setupObservers() {
        pokemonViewModel.pokemons.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { pokemonList -> renderList(pokemonList.results) }
                    recyclerViewPokemon.visibility = View.VISIBLE
                }

                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerViewPokemon.visibility = View.GONE
                }

                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        pokemonViewModel.handleAction.observe(this, {
            openDetailScreen(it)
        })
    }

    private fun addScrollerListener()
    {
        //attaches scrollListener with RecyclerView
        recyclerViewPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener()
        {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)
            {
                super.onScrolled(recyclerView, dx, dy)
                val height = recyclerView.height

                val diff = height-dy
                if (diff < 1000){
                    pokemonViewModel.retrievePokemons()
                }

            }
        })
    }

    private fun renderList(pokemons: List<Pokemon>) {
        pokemonAdapter.addData(pokemons)
        pokemonAdapter.notifyDataSetChanged()
    }

    private fun openDetailScreen(id: Int) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("EXTRA_POKEMON", id)
        startActivity(intent)
    }
}