package com.example.poke_desc.data.model

data class Sprite(
    val backDefault: String,
    val backFemale: Any? = null,
    val backShiny: String,
    val backShinyFemale: Any? = null,
    val frontDefault: String,
    val frontFemale: Any? = null,
    val frontShiny: String,
    val frontShinyFemale: Any? = null,
)