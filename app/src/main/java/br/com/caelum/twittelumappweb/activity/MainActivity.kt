package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorDeTweetsFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import br.com.caelum.twittelumappweb.fragment.MapaFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener {item ->

            when (item.itemId) {
                R.id.menu_tweets -> exibeFragment(ListaTweetsFragment())
                R.id.menu_busca  -> exibeFragment(BuscadorDeTweetsFragment())
                R.id.menu_mapa   -> exibeFragment(MapaFragment())
            }

            return@setOnNavigationItemSelectedListener true
        }

        bottom_navigation.selectedItemId = R.id.menu_tweets

        fab_add_tweet.setOnClickListener {
            val intent = Intent(this, TweetActivity::class.java)
            startActivity(intent)
        }
    }

    private fun exibeFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()

    }
}