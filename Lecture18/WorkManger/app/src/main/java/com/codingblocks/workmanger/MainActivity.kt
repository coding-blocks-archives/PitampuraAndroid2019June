package com.codingblocks.workmanger

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel("first","defaault",
                NotificationManager.IMPORTANCE_DEFAULT))
        }

        scheduleTask()
    }

    private fun scheduleTask() {
        val workerRequest = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
            .build()

        WorkManager.getInstance().enqueue(workerRequest)
    }
}
