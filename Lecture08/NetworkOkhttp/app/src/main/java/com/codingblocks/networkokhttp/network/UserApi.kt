package com.codingblocks.networkokhttp.network

import com.codingblocks.networkokhttp.modal.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi{

    @GET("/users")
    suspend fun getUsers():Response<List<User>>

    @GET("/users/{id}")
    fun getuserById(@Path("id") id:Int)

    @GET("/users")
    fun getuserByIdQuery(@Query("id") id:Int)

    @GET("/users")
    fun getUsersNormal():Call<List<User>>

//    @POST("/users")
//    fun postuser()
}