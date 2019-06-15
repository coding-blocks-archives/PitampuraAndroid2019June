package com.codingblocks.listsapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_color.view.*

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

        lvColors.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(
                this,
                "Clicked on $position : ${view.tvColor.text}",
                Toast.LENGTH_SHORT
            ).show()

        }

    }
}
