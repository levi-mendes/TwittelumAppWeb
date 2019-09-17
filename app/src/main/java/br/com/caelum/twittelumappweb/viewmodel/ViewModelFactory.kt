package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepositorio

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun tweetRepository() = TweetRepository()
    private fun usuarioRepository() = UsuarioRepositorio()


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass) {

        TweetViewModel::class.java -> {
            TweetViewModel(tweetRepository()) as T

        } else -> {
            UsuarioViewModel(usuarioRepository()) as T
        }
    }

}