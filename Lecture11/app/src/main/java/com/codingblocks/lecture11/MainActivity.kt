package com.codingblocks.lecture11

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStatusCodes
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Permission

class MainActivity : AppCompatActivity(), LocationListener {

    private  val LOCATION_REQ = 123
    private val CHECK_REQ = 121

    private var myLat = 0.0
    private var myLong = 0.0

    private var locationManager:LocationManager? = null
    override fun onLocationChanged(p0: Location?) {
        p0?.let {
            tvLocation.text = """
                My Location ${it.latitude}, ${it.longitude}
                Accuracy ${it.accuracy}
                Provider ${it.provider}
            """.trimIndent()

            myLat = it.latitude
            myLong = it.longitude
        }
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    }

    override fun onProviderEnabled(p0: String?) {
    }

    override fun onProviderDisabled(p0: String?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            checkUserSettingsAndGetLocation()
        }

        buttonMap.setOnClickListener {
            val intent = Intent(this,MapsActivity::class.java).apply {
                putExtra("myLat",myLat)
                putExtra("myLong",myLong)
            }
            startActivity(intent)

        }
    }

    private fun checkAndStartLocationUpdates(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                LOCATION_REQ
            )
        }else{
            getLocationSmart()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocationSmart(){
        val client = LocationServices.getFusedLocationProviderClient(this)
        client.lastLocation.apply {
            addOnFailureListener{

            }
            addOnSuccessListener {
                tvLocation.text = """
                My Location ${it.latitude}, ${it.longitude}
                Accuracy ${it.accuracy}
                Provider ${it.provider}
            """.trimIndent()

                myLat = it.latitude
                myLong = it.longitude
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CHECK_REQ){
            if (resultCode == Activity.RESULT_OK){
                checkAndStartLocationUpdates()
            }else{
                Toast.makeText(this,"Enable Location",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkUserSettingsAndGetLocation(){

        val locationRequest = LocationRequest().apply {
            interval = 1000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        val request = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
            .build()
        val client = LocationServices.getSettingsClient(this)

        client.checkLocationSettings(request).apply {
            addOnSuccessListener {
                Log.i("PUI","success")
                checkAndStartLocationUpdates()
            }
            addOnFailureListener{
                val e = it as ApiException
                if (e.statusCode == LocationSettingsStatusCodes.RESOLUTION_REQUIRED){
                    val resolvable = it as ResolvableApiException
                    resolvable.startResolutionForResult(this@MainActivity,CHECK_REQ)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == LOCATION_REQ){
            for(i in grantResults.indices){
                if (grantResults[i]!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Please Give ${permissions[i]}",Toast.LENGTH_LONG).show()
                    return
                }
            }
            getLocationSmart()
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val enabledProvider =
            when {
                locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER) -> LocationManager.NETWORK_PROVIDER
                locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER) -> LocationManager.GPS_PROVIDER
                else -> "nill"
            }
        locationManager?.requestLocationUpdates(
            enabledProvider,
            1000,
            0f,
            this
        )
    }

    override fun onDestroy() {
        locationManager?.removeUpdates(this)
        super.onDestroy()
    }
}
