package com.example.poke_desc.data.repository

import com.example.poke_desc.data.api.ApiHelper

class PokemonRepository(private val apiHelper: ApiHelper) {
    suspend fun getPokemons(offset: String) = apiHelper.getPokemons(offset)
    suspend fun getPokemon(id: Int) = apiHelper.getPokemon(id)
}