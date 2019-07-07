package com.codingblocks.filereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("FILES", "Files dir = ${filesDir.path}")

        btnSave.setOnClickListener {
            // Save data of etData to file

            val file = File(filesDir, "myfile.txt")
            Log.d("FILES", "exists = ${file.exists()}")
        }

        btnRestore.setOnClickListener {
            // Restore data from file and show in tvFileText
        }
    }
}
