package com.codingblocks.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val OP_ADD = 1
    val OP_SUB = 2
    val OP_MUL = 3
    val OP_DIV = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mem = 0
        var op = 0

        btnClr.setOnClickListener {
            tv.text = "0"
        }

        btn1.setOnClickListener {
            if (tv.text == "0") tv.text = "1"
            else tv.text = tv.text.toString() + "1"
        }

        btnAdd.setOnClickListener {
            op = OP_ADD
            mem = tv.text.toString().toInt()
            tv.text = "0"
        }

        btnEq.setOnClickListener {
            if (op == 0) return@setOnClickListener

            when(op) {
                OP_ADD -> tv.text = (mem + tv.text.toString().toInt()).toString()
            }
        }

    }
}
