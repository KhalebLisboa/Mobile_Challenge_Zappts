package com.example.mobilechallengezappts.model.network

import com.example.mobilechallengezappts.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

    @GET("pokemon/{id}")
    suspend fun getPokemonData(@Path("id") id : Int) : Response<Pokemon>
}