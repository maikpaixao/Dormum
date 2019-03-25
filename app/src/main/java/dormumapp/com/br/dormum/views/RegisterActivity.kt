package dormumapp.com.br.dormum.views

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
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
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //var user = ParseObject("Usuarios")
        var user = ParseUser()

        var nomeUsuario = register_username.text
        var senhaUsuario = register_pass.text
        var senhaUsuarioConfimacao = register_pass_confirmation.text
        var emailUsuario = register_email.text

        btn_signup.setOnClickListener(){
            if(nomeUsuario.equals("") || senhaUsuario.equals("") || senhaUsuarioConfimacao.equals("") || emailUsuario.equals("")){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }else if(!senhaUsuario.toString().equals(senhaUsuarioConfimacao.toString())){
                Toast.makeText(this, "As senhas digitadas não são compatíveis.", Toast.LENGTH_LONG).show()
            }else{
                user.username = nomeUsuario.toString()
                user.setPassword(senhaUsuario.toString())
                user.email = emailUsuario.toString()
                user.put("sexo", "masculino")

                //user.put("nomeUsuario", nomeUsuario.toString())
                //user.put("senhaUsuario", senhaUsuario.toString().toInt())
                //user.put("emailUsuario", emailUsuario.toString())

                //user.saveInBackground(){
                user.signUpInBackground(){
                    if (it == null) {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }else {
                        ParseUser.logOut();
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }

                }


            }
        }

    }

}
