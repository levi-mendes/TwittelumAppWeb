package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.network.LoginApi

class UsuarioRepositorio(private val api: LoginApi) {

    suspend fun criarConta(usuario: Usuario) = api.cria(usuario)

    suspend fun login(usuario: Usuario) = api.loga(usuario)
}