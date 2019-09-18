package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.viewmodel.SplashViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory

class SplashActivity : AppCompatActivity() {

    /*
        private val viewModel: UsuarioViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(UsuarioViewModel::class.java)
    }
     */
    private val viewModel: SplashViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            var intent = Intent(this, LoginActivity::class.java)

            if (viewModel.estaLogado()) {
                intent = Intent(this, MainActivity::class.java)
            }

            startActivity(intent)
            finish()

        }, 2000)
    }

}