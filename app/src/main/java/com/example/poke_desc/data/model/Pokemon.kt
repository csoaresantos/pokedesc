package com.example.poke_desc.data.model

import com.example.poke_desc.BuildConfig
import com.squareup.moshi.Json

data class Pokemon (
    @Json(name = "weight")
    val weight: Long,

    @Json(name = "abilities")
    val abilities: List<Ability>,

    @Json(name = "baseExperience")
    val baseExperience: Long,

    @Json(name = "forms")
    val forms: List<Specie>,

    @Json(name = "height")
    val height: Long,

    @Json(name = "id")
    val id: Long,

    @Json(name = "name")
    val name: String,

    @Json(name = "order")
    val order: Long,

    @Json(name = "species")
    val specie: Specie,

    @Json(name = "order")
    val sprite: Sprite,

    @Json(name = "order")
    val types: List<Type>,

    @Json(name = "url")
    val url: String,

    @Json(name = "stats")
    val stats: List<Stat>
) {
    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return BuildConfig.BASE_IMAGE_URL.plus(index.plus(".png"));
    }

    fun getIndexAsId(): String {
        return url.split("/".toRegex()).dropLast(1).last().toString()
    }

    fun getImageUrlBasedOnId(): String {
        return BuildConfig.BASE_IMAGE_URL.plus(id.toString().plus(".png"));
    }
}
