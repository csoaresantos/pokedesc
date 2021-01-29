package com.example.poke_desc.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.data.repository.PokemonRepository
import com.example.poke_desc.utils.NetworkHelper
import com.example.poke_desc.utils.Resource
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val pokemonRepository: PokemonRepository,
    private val networkHelper: NetworkHelper
): ViewModel() {
    private val _pokemonDetail = MutableLiveData<Resource<Pokemon>>()
    val pokemon: LiveData<Resource<Pokemon>>
        get() = _pokemonDetail

    fun getPokemonDetail(pokemonId: Int) {
        viewModelScope.launch {
            _pokemonDetail.postValue(Resource.loading(null))
            pokemonRepository.getPokemon(pokemonId).let {
                if(networkHelper.isNetworkConnected()) {
                    if(it.isSuccessful) {
                        _pokemonDetail.postValue(Resource.success(it.body()))
                    } else {
                        _pokemonDetail.postValue(Resource.error(it.body().toString(), null))
                    }
                } else _pokemonDetail.postValue(Resource.error("Request fail, internet is missing!", null))
            }
        }
    }
}