package com.example.mobilechallengezappts.model.network

import com.example.mobilechallengezappts.model.RequisitionResponse
import com.example.mobilechallengezappts.model.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit : Int) : Response<Results>
}