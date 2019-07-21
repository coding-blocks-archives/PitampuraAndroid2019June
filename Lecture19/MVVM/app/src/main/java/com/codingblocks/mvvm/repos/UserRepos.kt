package com.codingblocks.mvvm.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codingblocks.mvvm.models.User

class UserRepos {
    fun getUser():MutableLiveData<User>{

        val userData:MutableLiveData<User> = MutableLiveData()
            //try this on own own
//        userData.value = Client.service.user.execute().body()
        userData.value = User("https://avatars1.githubusercontent.com/u/29139786?v=4",
            "Pulkit Aggarwal",
            "aggarwalpulkit596")
        return userData
    }
}