package br.com.caelum.twittelumappweb

import android.app.Application

class TweetelumApplication : Application()  {

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {

        private lateinit var instance: TweetelumApplication

        fun getInstance() = instance
    }
}