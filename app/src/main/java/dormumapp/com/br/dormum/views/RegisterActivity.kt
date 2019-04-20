package dormumapp.com.br.dormum.views

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseUser
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.dao.RepoUsuario
import dormumapp.com.br.dormum.models.Usuario
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var repositorio = RepoUsuario()

        var nomeUsuario = register_username.text.toString()
        var senhaUsuario = register_pass.text.toString()
        var senhaUsuarioConfimacao = register_pass_confirmation.text.toString()
        var emailUsuario = register_email.text.toString()

        btn_signup.setOnClickListener(){
            if(nomeUsuario.equals("") || senhaUsuario.equals("") || senhaUsuarioConfimacao.equals("") || emailUsuario.equals("")){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }else if(!senhaUsuario.toString().equals(senhaUsuarioConfimacao.toString())){
                Toast.makeText(this, "As senhas digitadas não são compatíveis.", Toast.LENGTH_LONG).show()
            }else{
                var usuario = Usuario(nomeUsuario, senhaUsuario, emailUsuario, "", "")
                repositorio.adicionarUsuario(LoginActivity::class.java, this, usuario)
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

    }

}
