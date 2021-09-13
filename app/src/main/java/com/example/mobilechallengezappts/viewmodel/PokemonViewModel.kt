package com.example.mobilechallengezappts.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilechallengezappts.model.Pokemon
import com.example.mobilechallengezappts.model.network.ClientAPI
import kotlinx.coroutines.launch
import java.lang.Exception

class PokemonViewModel() : ViewModel() {

    var pokemon = MutableLiveData<List<Pokemon>>()
    private var pokemonList = ArrayList<Pokemon>()
    private val network = ClientAPI.getService()
    private var id_viewmodel = 0


    fun getPokemonData() {
        id_viewmodel += 1
        viewModelScope.launch {
            try {
                network.getPokemonData(id_viewmodel).body()?.let { it ->
                    pokemonList.add(it)
                    pokemon.value = pokemonList.toList().sortedWith(compareBy { it.id })

                }
            } catch (e: Exception) {

            }
        }
    }
}