package com.codingblocks.navigation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.chageActivity
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Hello World Welcome to Toolbar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        chageActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.button1 -> {
            Toast.makeText(this, "Toolbar Button", Toast.LENGTH_LONG).show()
            true
        }
        android.R.id.home ->{
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }


}
