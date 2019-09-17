package br.com.caelum.twittelumappweb.data

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioRepositorio {

    fun criarConta(usuario: Usuario) = Log.i("CriaConta", "$usuario")

    fun login(usuario: Usuario) = Log.i("LoginConta", "$usuario")
}