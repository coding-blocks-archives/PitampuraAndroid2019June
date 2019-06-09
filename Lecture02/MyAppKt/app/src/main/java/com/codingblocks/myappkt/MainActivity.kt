package com.codingblocks.myappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            val a = etVar1.text.toString().toInt()
            val b = etVar2.text.toString().toInt()
            val c = (a + b).toString()
            tvResult.text = c
        }
    }
}
