package com.example.simply_watered_kotlin.Interface

import com.example.simply_watered_kotlin.Model.Movie
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}