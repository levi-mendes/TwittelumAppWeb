package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.*
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lista_tweets.*

class BuscadorDeTweetsFragment: Fragment() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lista_tweets, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_buscador, menu)

        val botaoBusca = menu.findItem(R.id.item_buscar)
        val search = botaoBusca.actionView as SearchView
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(texto: String?): Boolean = false

            override fun onQueryTextChange(texto: String?): Boolean {
                if (!texto.isNullOrEmpty()) {
                    val filtrados = filtraTweetPeloTexto(texto)
                    lista_tweets.adapter = TweetAdapter(filtrados!!)
                }

                return true
            }
        })
    }

    private fun filtraTweetPeloTexto(texto: String?): List<Tweet>? {
        val tweets = viewModel.getTweets()

        return tweets.value?.filter {
            it.mensagem.contains(texto!!, ignoreCase = true)
        }
    }
}