package com.codingblocks.intentfilters

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBrowse.setOnClickListener {
            val i = Intent()
            // VIEW, DIAL, SEND, EDIT <- common intents
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse(etData.text.toString())
            try {
                startActivity(i)
            } catch (e: ActivityNotFoundException) {

                Toast.makeText(
                    this,
                    "No app found to open this",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
