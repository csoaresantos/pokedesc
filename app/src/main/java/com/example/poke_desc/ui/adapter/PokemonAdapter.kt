package com.example.poke_desc.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poke_desc.R
import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.ui.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.item_layout.view.*

class PokemonAdapter(
    private val pokemons: ArrayList<Pokemon>,
    private var pokemonViewModel: PokemonViewModel
) : RecyclerView.Adapter<PokemonAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View, private var pokemonViewModel: PokemonViewModel) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(pokemon: Pokemon) {
            itemView.tvName.text = pokemon.name
            Glide.with(itemView.imageViewAvatar.context)
                .load(pokemon.getImageUrl())
                .into(itemView.imageViewAvatar)
            itemView.setOnClickListener {
                pokemonViewModel.handleAction.postValue(pokemon.getIndexAsId().toInt())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent, false
            ),
            pokemonViewModel
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    override fun getItemCount(): Int = pokemons.size

    fun addData(pokemonList: List<Pokemon>) {
        pokemons.addAll(pokemonList)
    }
}