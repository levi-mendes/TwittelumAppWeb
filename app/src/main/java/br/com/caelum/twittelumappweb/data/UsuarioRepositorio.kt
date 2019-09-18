package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.LoginStorage
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.network.LoginApi

class UsuarioRepositorio(private val api: LoginApi, private val storage: LoginStorage) {

    suspend fun criarConta(usuario: Usuario):Usuario {
        val logado = api.cria(usuario)

        storage.salva(logado)

        return logado
    }

    suspend fun login(usuario: Usuario): Usuario {
        val logado = api.loga(usuario)

        storage.salva(logado)

        return logado
    }
}