package com.codingblocks.listsapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val colors = arrayOf(
        "red", "green", "blue",
        "cyan", "magenta", "yellow",
        "black", "white", "grey",
        "purple", "orange", "brown",
        "teal", "aqua", "indigo",
        "pink", "turquoise", "seagreen"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorAdapter = ArrayAdapter<String>(
            this,
            R.layout.list_item_color,
            R.id.tvColor,
            colors
        )
        lvColors.adapter = colorAdapter

    }
}
