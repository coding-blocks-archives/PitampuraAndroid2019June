package com.codingblocks.networkokhttp.network

import com.codingblocks.networkokhttp.modal.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi{

    @GET("/users")
    suspend fun getUsers():Response<List<User>>
}