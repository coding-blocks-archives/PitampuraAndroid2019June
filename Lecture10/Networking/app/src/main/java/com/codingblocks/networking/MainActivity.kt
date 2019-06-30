package com.codingblocks.networking

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.getData
import kotlinx.android.synthetic.main.activity_main.githubRv
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData.setOnClickListener {
            val networkTask = NetworkTask()
            networkTask.execute(
                "https://api.github.com/search/users?q=Pulkit%20Aggarwal"
                , "https://api.github.com/search/users?q=Pulkit%20Aggarwal"
            )
        }


    }

    inner class NetworkTask : AsyncTask<String, Int, String>() {

        override fun onPostExecute(result: String?) {
            val userList = arrayListOf<Item>()
            val githubData = Gson().fromJson(result, Example::class.java)
            userList.addAll(githubData.items)
//            val jsonData = JSONObject(result)
//            val itemsList = jsonData.getJSONArray("items")
//            for (i in 0..8) {
//                val users = Users(
//                    (itemsList[i] as JSONObject).getString("login"),
//                    (itemsList[i] as JSONObject).getString("avatar_url"),
//                    (itemsList[i] as JSONObject).getInt("id")
//                )
//                userList.add(users)
//            }
            githubRv.layoutManager = LinearLayoutManager(this@MainActivity)
            githubRv.adapter = GithubUserAdapter(this@MainActivity, userList)
        }

        override fun doInBackground(vararg urls: String?): String {

            val googleUrl: URL = URL(urls[0])
            val connection = googleUrl.openConnection() as HttpURLConnection
            val isr = InputStreamReader(connection.inputStream)
            val bufferReader = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer: String? = ""
            while (buffer != null) {
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }
            return sb.toString()
        }
    }
}
