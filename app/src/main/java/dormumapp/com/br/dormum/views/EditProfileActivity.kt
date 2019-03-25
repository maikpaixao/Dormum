package dormumapp.com.br.dormum.views

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.provider.MediaStore
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import dormumapp.com.br.dormum.R
import kotlinx.android.synthetic.main.activity_edit_profile.*
import java.io.IOException
import java.io.InputStream
import java.net.URL

class EditProfileActivity : AppCompatActivity() {

    var PICK_IMAGE: Int = 1
    lateinit var bmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        var listaCidades = arrayOf("Recife", "Jaboatão", "Olinda")
        spinner_profile_cidade.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listaCidades) as SpinnerAdapter?

        var listaSexo = arrayOf("Masculino", "Feminino", "Outro")
        spinner_profile_sexo.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listaSexo) as SpinnerAdapter?

        var query: ParseQuery<ParseObject> = ParseQuery.getQuery("Usuarios")
        query.whereEqualTo("nomeUsuario", "maik.paixao")
        query.getFirstInBackground(){obj, e ->
            update_user_name.text = Editable.Factory.getInstance().newEditable(obj.getString("nomeUsuario"))
            update_user_email.text = Editable.Factory.getInstance().newEditable(obj.getString("emailUsuario"))
        }

        button_edit.setOnClickListener(){
            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE) {
            val selectedFile = data?.data //The uri with the location of the file
            bmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedFile)

        }
    }
}
