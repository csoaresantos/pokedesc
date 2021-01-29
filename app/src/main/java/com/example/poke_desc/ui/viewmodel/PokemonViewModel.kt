package com.example.poke_desc.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_desc.data.model.PokemonCatalog
import com.example.poke_desc.data.repository.PokemonRepository
import com.example.poke_desc.utils.NetworkHelper
import com.example.poke_desc.utils.Resource
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val pokemonRepository: PokemonRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private var offset = 0
    private val _pokemons = MutableLiveData<Resource<PokemonCatalog>>()
    val pokemons: LiveData<Resource<PokemonCatalog>>
        get() = _pokemons

    val handleAction = MutableLiveData<Int>()

    init {
        retrievePokemons()
    }

    fun retrievePokemons() {
        viewModelScope.launch {
            _pokemons.postValue(Resource.loading(null))

            if (networkHelper.isNetworkConnected()) {
                pokemonRepository.getPokemons(offset.toString()).let {
                    if (it.isSuccessful) {
                        _pokemons.postValue(Resource.success(it.body()))
                        offset += 20
                    } else _pokemons.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else
                _pokemons.postValue(Resource.error("Internet connection missing!", null))

        }
    }
}