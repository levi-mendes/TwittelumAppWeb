package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepositorio
import br.com.caelum.twittelumappweb.modelo.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepositorio) : ViewModel() {

    val usuarioLiveData = MutableLiveData<Usuario>()
    val errorLiveData = MutableLiveData<Exception>()

    //fun criar(usuario: Usuario) = repository.criarConta(usuario)
    //fun logar(usuario: Usuario) = repository.login(usuario)

    fun criar(usuario: Usuario) {
        CoroutineScope(context = Dispatchers.IO).launch {
            try {
                val novoUsuario = repository.criarConta(usuario)

                launch (context = Dispatchers.Main) {
                    usuarioLiveData.postValue(novoUsuario)
                }

            } catch (error: Exception) {
                errorLiveData.postValue(error)
            }
        }
    }

    fun logar(usuario: Usuario) {
        CoroutineScope(context = Dispatchers.IO).launch {
            try {
                val novoUsuario = repository.login(usuario)

                launch (context = Dispatchers.Main) {
                    usuarioLiveData.postValue(novoUsuario)
                }
            } catch (error: Exception) {
                errorLiveData.postValue(error)
            }
        }
    }
}