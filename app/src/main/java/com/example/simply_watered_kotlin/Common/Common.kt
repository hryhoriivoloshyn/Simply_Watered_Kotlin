package com.example.simply_watered_kotlin.Common

import com.example.simply_watered_kotlin.Interface.RetrofitServices
import com.example.simply_watered_kotlin.Retrofit.RetrofitClient


object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}