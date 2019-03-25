package dormumapp.com.br.dormum.views

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import com.parse.ParseFile
import com.parse.ParseObject
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.Imovel
import kotlinx.android.synthetic.main.activity_imovel.*
import kotlinx.android.synthetic.main.activity_imovel.view.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

class ImovelActivity : AppCompatActivity() {

    var PICK_IMAGE: Int = 1
    lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imovel)

        var imoveis = ParseObject("Imoveis")

        var listaStrings = arrayOf("Recife", "Jaboatão", "Olinda")
        spinnerImovel.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listaStrings) as SpinnerAdapter?

        var listaQtd = arrayOf(1, 2, 3, 4, 5)
        spinnerQtd.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listaQtd) as SpinnerAdapter?


        var titulo = tituloImovel.text
        var descricao = descricaoImovel.text
        var preco = precoImovel.text
        var endereco = enderecoImovel.text

        btn_image.setOnClickListener(){
            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
        }

        btn_imovel.setOnClickListener(){
            var qtdPessoas = spinnerQtd.selectedItem.toString()
            var cidade = spinnerImovel.selectedItem.toString()

            var nomeFile = "${UUID.randomUUID()}.jpg"
            val blob = ByteArrayOutputStream()

            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, blob)

            var imgArray = blob.toByteArray()

            var parseImg = ParseFile(nomeFile, imgArray)

            //var imovelObj: Imovel = Imovel(tituloImovel.toString(), bitmap, R.drawable.review, "94,5")

            imoveis.put("imgImovel", parseImg)
            imoveis.put("tituloImovel", titulo.toString())
            imoveis.put("descricaoImovel", descricao.toString())
            imoveis.put("cidadeImovel", cidade)
            imoveis.put("precoImovel", preco.toString())
            imoveis.put("enderecoImovel", endereco.toString())
            imoveis.put("quantidadePessoas", qtdPessoas)

            imoveis.saveInBackground()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE) {
            val selectedFile = data?.data //The uri with the location of the file
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedFile)

        }
    }
}
