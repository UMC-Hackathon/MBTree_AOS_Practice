package com.umc.project.mbtree

import android.Manifest
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_location.*
import java.util.*

class LocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            locationManager!!.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                10,
                0f,
                LocationListner()
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0f,LocationListner())
    }

    internal inner class LocationListner : LocationListener {
        override fun onLocationChanged(p0: Location) {
            val geocoder:Geocoder= Geocoder(this@LocationActivity, Locale.KOREAN)
            var list = geocoder.getFromLocation(p0.latitude,p0.longitude,1) as List<Address>
            var currentLocation = LatLng(p0.latitude,p0.longitude)
            Log.d("주소",list[0].getAddressLine(0))
            txt.text="위도: "+p0.longitude+"\n경도 : "+p0.latitude+"\n 주소 : " + list[0].getAddressLine(0)+"\n 주소 : " + currentLocation
        }

    }
}