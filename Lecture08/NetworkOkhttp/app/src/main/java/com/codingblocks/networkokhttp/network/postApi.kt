package com.codingblocks.networkokhttp.network

import com.codingblocks.networkokhttp.modal.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface postApi{

    @GET("/posts")
    fun getPostsByUserId(@Query("userId")userId:Int):Call<List<Post>>
}