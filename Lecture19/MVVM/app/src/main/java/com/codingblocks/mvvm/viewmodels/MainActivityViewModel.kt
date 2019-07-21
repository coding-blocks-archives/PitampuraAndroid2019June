package com.codingblocks.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingblocks.mvvm.models.User

class MainActivityViewModel : ViewModel(){

    private val user:MutableLiveData<User> = MutableLiveData()


    fun getUser():LiveData<User> = user


}