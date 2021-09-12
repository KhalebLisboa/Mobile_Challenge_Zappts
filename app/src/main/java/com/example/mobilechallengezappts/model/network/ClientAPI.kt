package com.example.mobilechallengezappts.model.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI() {

    companion object{


        private var retrofitInstance : Retrofit? = null

        @JvmName("getRetrofitInstance1")
        private fun getRetrofitInstance() : Retrofit{
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            if(retrofitInstance == null){
                retrofitInstance = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofitInstance!!
        }

        fun getService() : ServiceAPI{
            return  getRetrofitInstance().create(ServiceAPI::class.java)
        }
    }
}