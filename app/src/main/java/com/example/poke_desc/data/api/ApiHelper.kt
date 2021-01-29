package com.example.poke_desc.data.api

import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.data.model.PokemonCatalog
import retrofit2.Response

interface ApiHelper {
    suspend fun getPokemons(offset: String): Response<PokemonCatalog>
    suspend fun getPokemon(id: Int): Response<Pokemon>
}