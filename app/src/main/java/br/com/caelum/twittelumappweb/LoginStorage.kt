package br.com.caelum.twittelumappweb

import android.content.Context
import br.com.caelum.twittelumappweb.modelo.Usuario

class LoginStorage (private val context: Context) {

    private val preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE)

    fun salva(logado: Usuario) = preferences.edit().putInt("id", logado.id).apply()

    fun getUsuarioLogado(): Usuario {
        val id = preferences.getInt("id", 0)
        return Usuario(id = id, senha = "", nome = "", username = "")
    }

    fun desloga() = preferences.edit().putInt("id", 0).apply()
}