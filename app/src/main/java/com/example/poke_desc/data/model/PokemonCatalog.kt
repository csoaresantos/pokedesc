package com.example.poke_desc.data.model

data class PokemonCatalog (
    val count: Long,
    val next: String,
    val previous: Any? = null,
    val results: List<Pokemon>
)