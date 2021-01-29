package com.example.poke_desc.data.api

import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.data.model.PokemonCatalog
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getPokemons(offset: String): Response<PokemonCatalog>  = apiService.getPokemons(offset)
    override suspend fun getPokemon(id: Int): Response<Pokemon> = apiService.getPokemon(id)

}