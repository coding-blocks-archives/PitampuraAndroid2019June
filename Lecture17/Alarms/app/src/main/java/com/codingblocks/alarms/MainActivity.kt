package com.codingblocks.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    val am by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nonRepeatingAlarams()
    }

    fun repeatingAlarms(){
        val intent = Intent(this,MainActivity::class.java)


        val pi  = PendingIntent.getActivity(this,123,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val calendar = Calendar.getInstance()
        calendar.set(2019,7,18,15,5)
        am.setRepeating(
            AlarmManager.RTC,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY * 7,
            pi
        )
    }

    fun nonRepeatingAlarams() {
        val intent = Intent(this, MainActivity::class.java)

        val pi = PendingIntent.getActivity(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val calendar = Calendar.getInstance();

        //need to call this to update thw calendar to the current time
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"))
        Log.i("time value", " " + calendar.timeInMillis + "    " + System.currentTimeMillis())
        if (Build.VERSION.SDK_INT >= 23) {
            am.setAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pi
            )
        } else if (Build.VERSION.SDK_INT >= 19) {
            am.setExact(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 15000,
                pi
            )
        } else {
            am.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 15000,
                pi
            )
        }
    }
}
