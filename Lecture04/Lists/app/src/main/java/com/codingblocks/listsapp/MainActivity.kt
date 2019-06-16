package com.codingblocks.listsapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.graphics.ColorUtils
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_color.view.*

class MainActivity : AppCompatActivity() {

    val colors = arrayOf(
        "red", "green", "blue",
        "cyan", "magenta", "yellow",
        "black", "white", "gray",
        "maroon", "maroon", "fuchsia",
        "navy", "olive", "teal"
    )

    val numList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..1000) {
            numList.add(i)
        }

        val colorAdapter = ColorAdapter(this, numList, colors)
        lvColors.adapter = colorAdapter


    }

    class ColorAdapter(val context: Context, val nums: ArrayList<Int>, val cols: Array<String>): BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            Log.d("LIST", "$position : ${convertView.toString()}")
            val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val itemView = convertView ?: li.inflate(R.layout.list_item_color, parent, false)

            val id = nums[position]
            val colorName = cols[position % 15]
            val color = Color.parseColor(colorName)

            itemView.llColorBox.setBackgroundColor(color)
            itemView.tvColor.text = colorName
            itemView.tvId.text = id.toString()
            return itemView
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return nums.size
        }

    }
}
