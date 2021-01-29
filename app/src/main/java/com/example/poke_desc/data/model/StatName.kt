package com.example.poke_desc.data.model

import com.squareup.moshi.Json

data class StatName (
    @Json(name = "name")
    val name: String
)