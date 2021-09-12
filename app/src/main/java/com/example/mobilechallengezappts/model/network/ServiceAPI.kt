package com.example.mobilechallengezappts.model.network

import retrofit2.http.GET

interface ServiceAPI {

    @GET("")
    fun fetchData(limit : Int)
}