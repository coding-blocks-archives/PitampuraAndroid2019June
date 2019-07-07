package com.codingblocks.filereadwrite

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            111
        )

        Log.d("FILES", "Files dir = ${filesDir.path}")


        val extDir = Environment.getExternalStorageDirectory()
        Log.d("FILES", "External dir = ${extDir.path}")


        val file = File(extDir, "myfile.txt")



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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if ((grantResults[0] == PackageManager.PERMISSION_DENIED) || (grantResults[1] == PackageManager.PERMISSION_DENIED)) {
            Toast.makeText(
                this,
                "Cannot run without permissions",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
