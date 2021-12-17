package com.example.simply_watered_kotlin.Interface

import com.example.simply_watered_kotlin.Model.RegionGroup
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {
    @GET("regiongroups")
    fun getMovieList(): Call<MutableList<RegionGroup>>

//    companion object {
//
//        var BASE_URL = "https://172.21.80.1:44312/api/
//
//        fun create() : ApiInterface {
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//            return retrofit.create(ApiInterface::class.java)
//
//        }
//    }
}