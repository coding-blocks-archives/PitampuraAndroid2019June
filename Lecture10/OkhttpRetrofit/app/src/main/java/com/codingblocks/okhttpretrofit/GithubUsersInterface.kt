package com.codingblocks.okhttpretrofit

import retrofit2.Call
import retrofit2.http.GET


interface GitHubService {
    @GET("search/users?q=Pulkit%20Aggarwal")
    fun listRepos(): Call<GithubUser>
}