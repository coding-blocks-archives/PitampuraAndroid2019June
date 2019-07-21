package com.codingblocks.workmanger

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel("first","defaault",
                NotificationManager.IMPORTANCE_DEFAULT))
        }

//        scheduleTask()
        scheduleRepeatingTasks()
    }

    private fun scheduleRepeatingTasks() {
        val constraints = Constraints.Builder().apply {
            setRequiredNetworkType(NetworkType.UNMETERED)
            setRequiresCharging(true)
            setRequiresDeviceIdle(false)
            setRequiresStorageNotLow(true)
        }.build()
        val repeatingWork = PeriodicWorkRequestBuilder<NetworkRequestWorker>(
            1,
            TimeUnit.DAYS
        ).setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(repeatingWork)
    }

    private fun scheduleTask() {
        val workerRequest = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
            .setInitialDelay(2,TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(this).enqueue(workerRequest)
    }
}
