package com.codingblocks.okhttpretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.textView2
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build();

        val service = retrofit.create(GitHubService::class.java)

        service.listRepos().enqueue(retrofitCallback { throwable, response ->
            response?.let {
                if (it.isSuccessful) {
                    runOnUiThread {
                        textView2.text = it.body().toString()

                    }
                }
            }

        })
    }
}
