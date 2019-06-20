package com.codingblocks.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.dc
import kotlinx.android.synthetic.main.activity_main.marvel

class MainActivity : AppCompatActivity() {
    lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bundle = Bundle()
        marvel.setOnClickListener {
            bundle.putString("NAME", "MARVEL")
            val frag = FragmentDC()
            frag.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.container, frag)
                .commit()
        }
        dc.setOnClickListener {
            bundle.putString("NAME", "DC")
            val frag = FragmentDC()
            frag.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.container, frag)
                .commit()
        }
    }
}
