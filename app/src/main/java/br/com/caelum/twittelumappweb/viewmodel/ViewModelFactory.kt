package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.LoginStorage
import br.com.caelum.twittelumappweb.TweetelumApplication
import br.com.caelum.twittelumappweb.data.SplashRepository
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepositorio
import br.com.caelum.twittelumappweb.network.InicializadorDoRetrofit
import br.com.caelum.twittelumappweb.network.LoginApi
import br.com.caelum.twittelumappweb.network.TweetApi

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun tweetApi()          = TweetApi(retrofit())
    private fun retrofit()          = InicializadorDoRetrofit().cria()
    private fun splashRepository()  = SplashRepository(storage())
    private fun context()           = TweetelumApplication.getInstance()
    private fun storage()           = LoginStorage(context())
    private fun loginApi()          = LoginApi(InicializadorDoRetrofit().cria())
    private fun tweetRepository()   = TweetRepository(tweetApi(), storage())
    private fun usuarioRepository() = UsuarioRepositorio(loginApi(), storage())
    val tweetViewModel = TweetViewModel(tweetRepository())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass) {

        TweetViewModel::class.java    -> {
            tweetViewModel as T

        } UsuarioViewModel::class.java -> {
            UsuarioViewModel(usuarioRepository()) as T

        } else -> {
            SplashViewModel(splashRepository()) as T
        }
    }

}