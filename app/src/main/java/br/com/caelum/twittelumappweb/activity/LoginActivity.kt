package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val viewModel: UsuarioViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(UsuarioViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_entrar.setOnClickListener { viewModel.logar(pegaUsuario()) }
        bt_criar.setOnClickListener {  viewModel.criar(pegaUsuario()) }

        tie_user_name.setText("levimendes")
        tie_senha.setText("123456")
        tie_nome.setText("Levi Mendes")
    }

    private fun pegaUsuario(): Usuario {

        val userName = tie_user_name.text.toString()
        val senha = tie_senha.text.toString()
        val nome = tie_nome.text.toString()

        return Usuario(nome = nome, userName = userName, senha = senha)
    }
}