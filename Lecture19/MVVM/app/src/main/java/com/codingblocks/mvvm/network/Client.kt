package com.codingblocks.mvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofitClient.create(GithubService::class.java)

}