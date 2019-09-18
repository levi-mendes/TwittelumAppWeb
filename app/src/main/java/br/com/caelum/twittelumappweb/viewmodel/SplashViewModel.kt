package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.SplashRepository

class SplashViewModel(private val repository: SplashRepository) : ViewModel() {

    fun estaLogado(): Boolean = repository.estaLogado()

}