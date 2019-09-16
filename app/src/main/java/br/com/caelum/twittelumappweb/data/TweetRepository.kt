package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetRepository {

    fun salva(tweet: Tweet) {}

    fun buscaTweets(): List<Tweet> {
        return arrayListOf(
            Tweet("Cuzcuz é bom"),
            Tweet("Pizza é melhor"),
            Tweet("Tapioca é bom"),
            Tweet("Pão de metro é melhor")
        )
    }

}