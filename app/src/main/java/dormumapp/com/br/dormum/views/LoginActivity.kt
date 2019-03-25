package dormumapp.com.br.dormum.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.content.*
import android.support.annotation.NonNull
import android.util.Log
import android.widget.Toast
import com.parse.*
import dormumapp.com.br.dormum.R

import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var emailLogin = login_email.text
        var senhaLogin = login_senha.text
        //var query: ParseQuery<ParseObject> = ParseQuery.getQuery("Usuarios")

        // Set up the login form.
        button_signin.setOnClickListener(){
            ParseUser.logInInBackground(emailLogin.toString(), senhaLogin.toString()){objeto , e ->
                if (objeto != null) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    System.out.println("Failed Login!")
                    //ParseUser.logOut()
                    Toast.makeText(this, "Falha ao logar! Username ou Senha inváldos!", Toast.LENGTH_LONG).show()
                }


            }
            //query.whereEqualTo("emailUsuario", emailLogin.toString())
            //query.getFirstInBackground(){obj, e ->
            //   System.out.println(obj.getString("nomeUsuario"))
            //}
            //startActivity(Intent(this, HomeActivity::class.java))
        }

        signup_action.setOnClickListener(){
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

}
