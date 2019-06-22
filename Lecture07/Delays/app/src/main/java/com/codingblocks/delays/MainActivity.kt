package com.codingblocks.delays

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0
    var tvField: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvField = findViewById(R.id.tvField)

        btnCount.setOnClickListener {
            count++
            tvField?.text = count.toString()
        }

        btnWait.setOnClickListener {

            WaitTask(tvField!!).execute()
        }
    }

    class WaitTask (val tv: TextView) : AsyncTask<Int, Float, String>() {

        override fun doInBackground(vararg params: Int?): String {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() < start + 5000) {}
            return "DONE"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tv.text = result

        }
    }
}
