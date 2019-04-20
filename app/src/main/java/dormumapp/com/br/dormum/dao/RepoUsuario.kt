package dormumapp.com.br.dormum.dao

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.parse.ParseUser
import dormumapp.com.br.dormum.models.Usuario
import dormumapp.com.br.dormum.views.LoginActivity
import dormumapp.com.br.dormum.views.RegisterActivity

class RepoUsuario{

    var user = ParseUser()

    fun adicionarUsuario(act: Class<LoginActivity>, context: Context, usuario: Usuario){
        user.username = usuario.username.toString()
        user.setPassword(usuario.password.toString())
        //user.email = emailUsuario.toString()

        user.signUpInBackground(){
            if (it != null) {
                ParseUser.logOut();
            }
        }

    }

}
