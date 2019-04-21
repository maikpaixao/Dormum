package dormumapp.com.br.dormum.controllers

import android.content.Context
import dormumapp.com.br.dormum.dao.RepoUsuario
import dormumapp.com.br.dormum.exceptions.NotFoundElement
import dormumapp.com.br.dormum.models.Usuario
import dormumapp.com.br.dormum.views.LoginActivity
import java.lang.Exception

class ControllerUsuario {

    val repoUsuario = RepoUsuario()

    fun  adicionarUsuario(act: Class<LoginActivity>, context: Context, usuario: Usuario){
        try {
            if(usuario == null){
                throw NotFoundElement("Elemento não encontrado!")
            }else{
                repoUsuario.adicionarUsuario(act, context, usuario)
            }
        }catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}