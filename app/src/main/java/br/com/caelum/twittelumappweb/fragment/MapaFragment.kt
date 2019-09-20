package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaFragment : SupportMapFragment(), OnMapReadyCallback {

    private lateinit var tweetViewModel: TweetViewModel

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        tweetViewModel = ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val lista = tweetViewModel.getTweets().value

        lista?.forEach {

            val marcador = MarkerOptions()

            marcador.position(LatLng(it.latitude, it.longitude))
            marcador.title(it.usuario.nome)
            marcador.snippet(it.mensagem)

            googleMap?.addMarker(marcador)
        }
    }
}