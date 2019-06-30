package com.codingblocks.okhttpretrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.getData
import kotlinx.android.synthetic.main.activity_main.textView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData.setOnClickListener {
            val client = OkHttpClient()

            val request = Request.Builder()
                .addHeader("Authorization","JWT eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Mzc5NzUsImZpcnN0bmFtZSI6IlB1bGtpdCIsImxhc3RuYW1lIjoiQWdnYXJ3YWwiLCJ1c2VybmFtZSI6ImFnZ2Fyd2FscHVsa2l0NTk2LWciLCJlbWFpbCI6ImFnZ2Fyd2FscHVsa2l0NTk2QGdtYWlsLmNvbSIsInZlcmlmaWVkZW1haWwiOiJhZ2dhcndhbHB1bGtpdDU5NkBnbWFpbC5jb20iLCJ2ZXJpZmllZG1vYmlsZSI6bnVsbCwibW9iaWxlIjoiKzkxLTk1ODIwNTQ2NjQiLCJvbmVhdXRoX2lkIjoiMTIwMzUiLCJsYXN0X3JlYWRfbm90aWZpY2F0aW9uIjoiMCIsInBob3RvIjoiaHR0cHM6Ly9ncmFwaC5mYWNlYm9vay5jb20vMTc4MzM4OTczNTAyODQ2MC9waWN0dXJlP3R5cGU9bGFyZ2UiLCJjb2xsZWdlIjoiQW1pdHkgU2Nob29sIE9mIEVuZ2luZWVyaW5nICYgVGVjaG5vbG9neSAoTm9pZGEpIiwib3JnYW5pemF0aW9uIjpudWxsLCJyb2xlSWQiOjIsImNyZWF0ZWRBdCI6IjIwMTgtMDktMjdUMTM6MTA6NTkuMzk2WiIsInVwZGF0ZWRBdCI6IjIwMTktMDUtMDRUMDU6MjU6MjQuNzQ2WiIsInJvbGUiOnsiaWQiOjIsIm5hbWUiOiJTdHVkZW50IiwiY3JlYXRlZEF0IjoiMjAxNy0wOS0wN1QxMDo1ODoxOS45OTNaIiwidXBkYXRlZEF0IjoiMjAxNy0wOS0wN1QxMDo1ODoxOS45OTNaIn0sImNsaWVudElkIjoiYmEzYzZkMTQtMTU0NS00YzljLTg3YjAtNjZmZGM3MzAyMTlmIiwiY2xpZW50IjoiYW5kcm9pZCIsImlhdCI6MTU1Njk0NzUyNCwiZXhwIjoxNTYyMzQ3NTI0fQ.Vdj6YiTGEJFzphJdqnLJP1vDK0CjpqSF2YQ5PFSp396Sc_WsiO5vnb7YYMEuCcIpmfnRxEKTT0Dpusfy6uXUiHQV9EH4B-qxeE7Q_pe_sEIGwAKxAT5vFwAwDkgIV69v15HqC6XYj2OVoOaP-4lVmNZOs-rV44YUXy45kk916ck0p3kpoofqBAX3zYNVd_9_l9BUuYglynDcejTREIUhRdmRF4hmlW4g-wyLnFz0E-u0e-SSQRrSDcsWE5fKfwtCLENR8BE3Qa1qVGzJVZ8avmn0-lS-FihdITlvNOnUgyQcTduPHzyuf7jiMY99Z31jiD53xfx6YevXINRA3n9Kjg")
                .url("https://api-online.cb.lk/api/v2/lectures/otp?videoId=60076fc4bdaf445383a38c2210d9508e&sectionId=1150&runAttemptId=11312https://api-online.cb.lk/api/v2/lectures/otp?videoId=60076fc4bdaf445383a38c2210d9508e&sectionId=663&runAttemptId=11312")
                .build()
            val response = client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val data =

                            Gson().fromJson(response.body?.string(), GithubUser::class.java)

                        runOnUiThread {
                            textView.text = data.items[0].toString()
                        }
                    } else {
                        runOnUiThread{
                            Toast.makeText(
                                this@MainActivity,
                                "" + response.code,
                                Toast.LENGTH_LONG
                            ).show()
                        }


                    }
                }

            })

        }
    }
}
