package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.modelo.Tweet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {

    private val tweets = MutableLiveData<List<Tweet>>()

    fun salva(tweet: Tweet) {
        CoroutineScope(context = Dispatchers.IO).launch {
            repository.salva(tweet)
        }
    }

    //fun listar(): LiveData<List<Tweet>> = repository.listar()

    fun getTweets() = tweets as LiveData<List<Tweet>>

    fun listar() {
        val lista: List<Tweet> = repository.buscaTweets()
        tweets.postValue(lista)
    }


}