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

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun splashRepository() = SplashRepository(storage())
    private fun context() = TweetelumApplication.getInstance()
    private fun storage() = LoginStorage(context())
    private fun loginApi() = LoginApi(InicializadorDoRetrofit().cria())
    private fun tweetRepository()   = TweetRepository()
    private fun usuarioRepository() = UsuarioRepositorio(loginApi(), storage())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass) {

        TweetViewModel::class.java    -> {
            TweetViewModel(tweetRepository()) as T

        } UsuarioViewModel::class.java -> {
            UsuarioViewModel(usuarioRepository()) as T

        } else -> {
            SplashViewModel(splashRepository()) as T
        }
    }

}