package com.example.poke_desc.data.model

import com.squareup.moshi.Json

data class Stat (
    @Json(name = "base_stat")
    val base_stat: Int,

    @Json(name = "stat")
    val stat: StatName
)