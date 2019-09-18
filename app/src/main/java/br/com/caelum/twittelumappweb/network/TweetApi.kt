package br.com.caelum.twittelumappweb.network

import br.com.caelum.twittelumappweb.dto.TweetDTO
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class TweetApi(retrofit: Retrofit) {

    private val service by lazy {
        retrofit.create(TweetService::class.java)
    }

    suspend fun cria(tweetDTO: TweetDTO) = service.cria(tweetDTO)

    suspend fun lista() = service.lista()

    interface TweetService {

        @POST("tweet")
        suspend fun cria(@Body tweetDTO: TweetDTO): TweetDTO

        @GET("tweet")
        suspend fun lista(): List<TweetDTO>
    }
}