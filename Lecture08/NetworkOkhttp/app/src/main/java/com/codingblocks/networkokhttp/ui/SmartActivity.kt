package com.codingblocks.networkokhttp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingblocks.networkokhttp.R
import com.codingblocks.networkokhttp.modal.User
import com.codingblocks.networkokhttp.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SmartActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            launch {
                val users = getUserRetrofit()
                rvUsers.layoutManager = LinearLayoutManager(
                    this@SmartActivity,
                    RecyclerView.VERTICAL,
                    false
                )
                rvUsers.adapter = UserAdapter(users)
            }
        }

    }

    suspend fun getUserRetrofit(): List<User> {
        val userApi = RetrofitClient.userApi

        val response = userApi.getUsers()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }
}
