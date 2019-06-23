package com.codingblocks.networkokhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingblocks.networkokhttp.modal.User
import com.codingblocks.networkokhttp.ui.UserAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.*
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    val supervisor = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + supervisor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
//            getUsers("https://jsonplaceholder.typicode.com/users")
            launch {
                val deferredUsers = getUsersSmart("https://jsonplaceholder.typicode.com/users")
                val users = deferredUsers.await()
                rvUsers.layoutManager =
                    LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
                rvUsers.adapter = UserAdapter(users)
            }
        }
    }


    fun getUsers(url:String){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                val token = parseJson(data!!)
                Log.i("PUI", "data $data")

                runOnUiThread {
                    rvUsers.layoutManager =
                        LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
                    rvUsers.adapter = UserAdapter(token)
                }

            }

        })
    }

    fun getUsersSmart(url:String):Deferred<List<User>>{
       return async(Dispatchers.IO) {
           val client = OkHttpClient()
           val request = Request.Builder()
               .url(url)
               .build()

           val data = client.newCall(request).execute()
           val jsondata = data.body()?.string()?:""
           val users = parseJson(jsondata)

           users
        }
    }


    fun parseJson(data:String):List<User>{
//        val jsonArray = JSONArray(data)
//        val list = arrayListOf<User>()
//
//        for(i in 0 until jsonArray.length()){
//            val userJson = jsonArray.getJSONObject(i)
//            val user = User(
//                userJson.getInt("id"),
//                userJson.getString("name"),
//                userJson.getString("username"),
//                userJson.getString("email")
//            )
//            list.add(user)
//        }

        val gson = Gson()
        val users = gson.fromJson(data,Array<User>::class.java)
        return users.toList()
    }



}
