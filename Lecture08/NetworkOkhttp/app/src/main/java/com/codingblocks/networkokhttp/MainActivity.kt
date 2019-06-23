package com.codingblocks.networkokhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            getUsers("https://jsonplaceholder.typicode.com/users")
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


    fun parseJson(data:String):List<User>{
        val jsonArray = JSONArray(data)
        val list = arrayListOf<User>()

        for(i in 0 until jsonArray.length()){
            val userJson = jsonArray.getJSONObject(i)
            val user = User(
                userJson.getInt("id"),
                userJson.getString("name"),
                userJson.getString("username"),
                userJson.getString("email")
            )
            list.add(user)
        }
        return list
    }
}
