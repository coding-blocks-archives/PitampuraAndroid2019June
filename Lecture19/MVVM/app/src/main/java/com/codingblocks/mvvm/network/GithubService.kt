package com.codingblocks.mvvm.network

import com.codingblocks.mvvm.models.User
import retrofit2.Call
import retrofit2.http.GET

interface GithubService{

    @get:GET("users/aggarwalpulkit596")
    val user : Call<User>
}