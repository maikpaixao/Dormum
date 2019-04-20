package dormumapp.com.br.dormum.models

import android.graphics.Bitmap
import android.media.Image
import android.widget.ImageView
import com.parse.ParseFile
import java.sql.Blob

class Imovel(titleImovel: String, descricaoImovel: String, enderecoImovel: String, cidadeImovel: String, qtdPessoas: String, imagemImovel: ParseFile, reviewId: Int, priceImovel: String){

    private var titleImovel: String
    private var descricaoImovel: String
    private var cidadeImovel: String
    private var qtdPessoas: String
    private var enderecoImovel: String
    private var imagemImovel: ParseFile
    private var reviewId: Int
    private var priceImovel: String

    init {
        this.titleImovel = titleImovel
        this.descricaoImovel = descricaoImovel
        this.cidadeImovel = cidadeImovel
        this.qtdPessoas = qtdPessoas
        this.enderecoImovel = enderecoImovel
        this.imagemImovel = imagemImovel
        this.reviewId = reviewId
        this.priceImovel = priceImovel
    }

    fun getTitleImovel(): String{
        return this.titleImovel
    }

    fun getDescricaoImovel(): String{
        return this.descricaoImovel
    }

    fun getCidadeImovel(): String{
        return this.cidadeImovel
    }

    fun getQtdPessoas(): String{
        return this.qtdPessoas
    }

    fun getImagemImovel(): ParseFile{
        return this.imagemImovel
    }

    fun getEnderecoImovel(): String{
        return this.enderecoImovel
    }

    fun getReviewId(): Int{
        return this.reviewId
    }

    fun getPriceImovel(): String{
        return this.priceImovel
    }
}