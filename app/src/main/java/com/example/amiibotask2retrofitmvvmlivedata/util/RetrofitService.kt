package com.example.amiibotask2retrofitmvvmlivedata.util

import com.example.amiibotask2retrofitmvvmlivedata.model.JSONResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    // @GET("movielist.json")
    @GET("amiibo/")
    fun getAllAmiibo(): Call<JSONResponse>
    companion object{
        var retrofitService:RetrofitService?=null
        fun getInstance():RetrofitService{
            if(retrofitService == null)
            {
                val retrofit= Retrofit.Builder()
                    // .baseUrl("https://howtodoandroid.com/")
                    .baseUrl("https://amiiboapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService=retrofit.create(RetrofitService::class.java)

            }
            return retrofitService!!
        }
    }
}