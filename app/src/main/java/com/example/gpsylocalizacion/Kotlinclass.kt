package com.example.gpsylocalizacion

class Kotlinclass {
    companion object{
        const val PERMISSION_ID = 33
    }
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    val tvLatitude: TextView = findViewById(R.id.tvLatitude)
    val tvLongitude: TextView = findViewById(R.id.tvLongitude)
    val btnLocate: Button = findViewById(R.id.btnLocate)

    private fun checkGranted(permission: String): Boolean{
        return ActivityCompat.checkSelfPermission(this, permission) ==
                PackageManager.PERMISSION_GRANTED
    }
    private fun checkPermissions() =
        checkGranted(Manifest.permission.ACCESS_COARSE_LOCATION) &&
                checkGranted(Manifest.permission.ACCESS_FINE_LOCATION)

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_ID
        )
    }

    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return
        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(
                    LocationManager.NETWORK_PROVIDER
                )
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnSuccessListener(this) { location -
                    >
                    tvLatitude.text = location?.latitude.toString()
                    tvLongitude.text = location?.longitude.toString()
                }
            }
        } else{
            requestPermissions()
        }
    }
}