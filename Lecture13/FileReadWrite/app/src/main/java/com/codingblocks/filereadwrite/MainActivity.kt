package com.codingblocks.filereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("FILES", "Files dir = ${filesDir.path}")
        val file = File(filesDir, "myfile.txt")

        btnSave.setOnClickListener {
            // Save data of etData to file

            Log.d("FILES", "exists = ${file.exists()}")
//            file.writeText(etData.text.toString())
            file.appendText(etData.text.toString())

//            val foutStream = FileOutputStream(file)
//            val bytes = etData.text.toString().toByteArray()
//            foutStream.write(bytes)
//            foutStream.close()
        }

        btnRestore.setOnClickListener {
            // Restore data from file and show in tvFileText
            val existingText = file.readText()
            tvFileText.text = existingText

//            val fis = FileInputStream(file)
//            val byteArray = ByteArray(20)
//            val isr = InputStreamReader(fis)
//            val br = BufferedReader(isr)
//            br.readLine()
        }
    }
}
