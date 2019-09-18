package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
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

        tie_user_name.setText("levi")
        tie_senha.setText("456")
        tie_nome.setText("Levi Mendes")

        viewModel.usuarioLiveData.observe(this, Observer {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        })

        viewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this, it?.message, Toast.LENGTH_LONG).show()
        })
    }

    private fun pegaUsuario(): Usuario {

        val userName = tie_user_name.text.toString()
        val senha = tie_senha.text.toString()
        val nome = tie_nome.text.toString()

        return Usuario(nome = nome, username = userName, senha = senha)
    }
}