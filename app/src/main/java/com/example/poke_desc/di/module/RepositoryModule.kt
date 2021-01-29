package com.example.poke_desc.di.module

import com.example.poke_desc.data.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { PokemonRepository(get()) }
}