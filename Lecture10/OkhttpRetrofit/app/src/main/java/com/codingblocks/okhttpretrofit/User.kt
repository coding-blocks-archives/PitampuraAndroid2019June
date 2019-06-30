package com.codingblocks.okhttpretrofit

data class GithubUser(
    val items: ArrayList<Users>
)

data class Users(
    val login: String,
    val avatar_url: String
)

