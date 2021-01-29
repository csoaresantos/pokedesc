package com.example.poke_desc.data.api

import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.data.model.PokemonCatalog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon?limit=20")
    suspend fun getPokemons(@Query("offset") offset: String): Response<PokemonCatalog>

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id")id: Int): Response<Pokemon>
}