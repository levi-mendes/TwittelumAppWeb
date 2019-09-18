package br.com.caelum.twittelumappweb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InicializadorDoRetrofit {

    fun cria(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://twittelum-server.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}