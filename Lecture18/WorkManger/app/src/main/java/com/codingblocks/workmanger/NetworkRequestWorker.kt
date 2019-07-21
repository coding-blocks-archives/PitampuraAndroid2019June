package com.codingblocks.workmanger

import android.app.NotificationManager
import android.content.Context
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class NetworkRequestWorker(val context: Context,workerParameters: WorkerParameters)
    : Worker(context,workerParameters){
    override fun doWork(): Result {
        val nm  = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context,"first").apply {
            setContentTitle("Background task")
            setContentText("Sample text")
            setSmallIcon(R.drawable.ic_launcher_foreground)
            priority = NotificationCompat.PRIORITY_DEFAULT
        }.build()

        nm.notify(System.currentTimeMillis().toInt(),notification)
        return Result.success()
    }

}