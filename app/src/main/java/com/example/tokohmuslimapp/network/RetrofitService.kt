package com.example.tokohmuslimapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    private val client = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://tokohapp-default-rtdb.firebaseio.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildServices(service : Class<T>) : T {

        return retrofit.create(service)

    }

}