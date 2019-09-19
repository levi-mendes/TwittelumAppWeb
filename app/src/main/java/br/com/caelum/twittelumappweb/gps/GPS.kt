package br.com.caelum.twittelumappweb.gps

import android.content.Context
import android.location.Location
import com.google.android.gms.location.*

class GPS (context: Context) : LocationCallback() {

    private val client: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    var lastLocation: Location? = null

    override fun onLocationResult(result: LocationResult?) {
        lastLocation = result?.lastLocation
    }

    fun fazBusca() {
        val requisicao = LocationRequest()

        requisicao.apply {
            interval = 1000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            smallestDisplacement = 10.0f
        }

        client.requestLocationUpdates(requisicao, this, null)
    }

    fun cancela() {
        client.removeLocationUpdates(this)
    }

    fun coordenadas(): Pair<Double, Double> {
        val latitude = lastLocation?.latitude ?: 0.0
        val longitude = lastLocation?.longitude ?: 0.0

        return Pair(latitude, longitude)
    }
}
