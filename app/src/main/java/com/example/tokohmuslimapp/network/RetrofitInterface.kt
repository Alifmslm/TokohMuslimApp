package com.example.tokohmuslimapp.network

import com.example.tokohmuslimapp.model.PenemuItem
import com.example.tokohmuslimapp.model.TokohItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("data/tokoh.json")
    suspend fun getDataTokoh() : Response<List<TokohItem>>

    @GET("data/penemu.json")
    suspend fun getDataPenemu() : Response<List<PenemuItem>>

}