package com.codingblocks.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingblocks.mvvm.models.User
import com.codingblocks.mvvm.repos.UserRepos

class MainActivityViewModel : ViewModel(){

    private var user:MutableLiveData<User> = MutableLiveData()
    private var userRepos:UserRepos? = null

    fun queryRepo(){
        userRepos = UserRepos()
        user= userRepos!!.getUser()
    }

    fun getUser():LiveData<User> = user


}