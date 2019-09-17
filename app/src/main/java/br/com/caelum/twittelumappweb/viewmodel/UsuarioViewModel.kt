package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepositorio
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel(private val repository: UsuarioRepositorio) : ViewModel() {

    fun criar(usuario: Usuario) = repository.criarConta(usuario)

    fun logar(usuario: Usuario) = repository.login(usuario)
}