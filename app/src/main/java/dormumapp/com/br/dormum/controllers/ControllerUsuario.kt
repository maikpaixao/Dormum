package dormumapp.com.br.dormum.controllers

import android.content.Context
import dormumapp.com.br.dormum.dao.RepoUsuario
import dormumapp.com.br.dormum.models.Usuario
import dormumapp.com.br.dormum.views.LoginActivity

class ControllerUsuario {

    val repoUsuario = RepoUsuario()

    fun  adicionarUsuario(act: Class<LoginActivity>, context: Context, usuario: Usuario){
        repoUsuario.adicionarUsuario(act, context, usuario)
    }
}