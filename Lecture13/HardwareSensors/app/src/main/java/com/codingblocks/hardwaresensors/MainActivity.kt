package com.codingblocks.hardwaresensors

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensors = sm.getSensorList(Sensor.TYPE_ALL)
        sensors.forEach {
            Log.d("SENSOR", """
                ${it.name}
                ${it.vendor}
            """.trimIndent())
        }
        val accelSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        val sensorListener  = object: SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

            override fun onSensorChanged(event: SensorEvent?) {
                Log.d("SENSOR", """
                    values :
                    ax: ${event?.values?.get(0)}
                    ay: ${event?.values?.get(1)}
                    az: ${event?.values?.get(2)}
                """.trimIndent())

                val ax = event?.values?.get(0) ?: 0f
                val ay = event?.values?.get(1) ?: 0f
                val az = event?.values?.get(2) ?: 0f

                clBackground.setBackgroundColor(
                    Color.rgb(
                        (((ax + 12) / 24) * 255).toInt(),
                        (((ay + 12) / 24) * 255).toInt(),
                        (((az + 12) / 24) * 255).toInt()
                    )
                )
            }
        }

        sm.registerListener(
            sensorListener,
            accelSensor,
            1000 * 60
        )
    }
}
