package com.codingblocks.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val KEY_DATA = "data"
    val KEY_APP_OPEN = "app_open"
    var appOpenCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getPreferences(Context.MODE_PRIVATE)

        appOpenCount = prefs.getInt(KEY_APP_OPEN, 0)
        appOpenCount++

        prefs.edit{
            putInt(KEY_APP_OPEN, appOpenCount)
        }

        tvOpenCount.text = appOpenCount.toString()

        btnSave.setOnClickListener {
            prefs.edit {
                putString(KEY_DATA, etData.text.toString())
            }
        }

        btnRestore.setOnClickListener {
            val data = prefs.getString(KEY_DATA, "")
            etData.setText(data)
        }
    }
}
