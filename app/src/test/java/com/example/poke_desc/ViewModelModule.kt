package com.example.poke_desc

import com.example.poke_desc.ui.viewmodel.PokemonDetailViewModel
import com.example.poke_desc.ui.viewmodel.PokemonViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PokemonViewModel(get(), get())

    }

    viewModel {
        PokemonDetailViewModel(get(), get())
    }
}