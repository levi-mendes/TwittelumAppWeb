package br.com.caelum.twittelumappweb.modelo

data class Tweet(val mensagem: String,
                 val foto: String? = null,
                 val latitude: Double,
                 val longitude: Double) {

    override fun toString(): String = mensagem

    //constructor() : this("", null, Usuario(), 0.0, 0.0)
}