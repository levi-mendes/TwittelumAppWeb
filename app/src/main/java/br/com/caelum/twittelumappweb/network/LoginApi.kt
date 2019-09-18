package br.com.caelum.twittelumappweb.network

import br.com.caelum.twittelumappweb.modelo.Usuario
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

class LoginApi (retrofit: Retrofit) {

    private val service: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }

    suspend fun loga(usuario: Usuario) = service.loga(usuario)

    suspend fun cria(usuario: Usuario) = service.cria(usuario)

    interface LoginService {

        @POST("usuario/login")
        suspend fun loga(@Body usuario: Usuario): Usuario

        @POST("usuario")
        suspend fun cria(@Body usuario: Usuario): Usuario
    }
}