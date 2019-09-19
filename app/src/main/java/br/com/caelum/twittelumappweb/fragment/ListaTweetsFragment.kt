package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lista_tweets.*
import kotlinx.android.synthetic.main.fragment_lista_tweets.view.*

class ListaTweetsFragment : Fragment() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_tweets, container, false)

        viewModel.listar()

        view.srl_lista_tweets.setOnRefreshListener { viewModel.listar() }

        view.srl_lista_tweets.setColorSchemeResources(android.R.color.white,
                android.R.color.holo_green_dark,
                android.R.color.holo_blue_dark)

        viewModel.getTweets().observe(this, Observer { tweets ->
            tweets?.let {
                lista_tweets.adapter = TweetAdapter(tweets)

                pb_carregando_lista.visibility = View.GONE
                view.srl_lista_tweets.isRefreshing = false
            }
        })

        return view
    }
}