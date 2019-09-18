package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.LoginStorage
import br.com.caelum.twittelumappweb.dto.TweetDTO
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.network.TweetApi

class TweetRepository (private val api: TweetApi, private val storage: LoginStorage) {

    suspend fun salva(tweet: Tweet) {
        val tweetDTO = TweetDTO(tweet.mensagem, tweet.foto, storage.getUsuarioLogado())

        api.cria(tweetDTO)
    }

    fun buscaTweets(): List<Tweet> {
        return arrayListOf(
            Tweet("Cuzcuz é bom"),
            Tweet("Pizza é melhor"),
            Tweet("Tapioca é bom"),
            Tweet("Pão de metro é melhor")
        )
    }

}