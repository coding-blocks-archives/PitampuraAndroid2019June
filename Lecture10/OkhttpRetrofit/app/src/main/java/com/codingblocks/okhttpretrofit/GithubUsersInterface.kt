package com.codingblocks.okhttpretrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface GitHubService {
    @GET("users/{userNo}")
    fun listRepos(@Path("userNo") search: String, @Query("q") query: String): Call<GithubUser>

    @POST("{search}/users")
    fun setRepos(@Body user: GithubUser,@Path("search") search: String, @Query("q") query: String): Call<GithubUser>
}