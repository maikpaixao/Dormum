package dormumapp.com.br.dormum.models

import android.media.Image
import android.widget.ImageView
import java.sql.Blob

class Imovel(titleImovel: String, imagemImovel: Int, reviewId: Int, priceImovel: String){

    private var titleImovel: String
    /**private var idImovel: Int
    private var descriptionImovel: String
    private var locationImovel: String
    private var typeImovel: String
    private var statusImovel: Boolean*/
    private var imagemImovel: Int
    private var reviewId: Int
    private var priceImovel: String

    init {
        this.titleImovel = titleImovel
        /**this.idImovel = idImovel
        this.titleImovel = titleImovel
        this.descriptionImovel = descriptionImovel
        this.locationImovel = locationImovel
        this.typeImovel = typeImovel
        this.statusImovel = statusImovel*/
        this.imagemImovel = imagemImovel
        this.reviewId = reviewId
        this.priceImovel = priceImovel
    }

    fun getTitleImovel(): String{
        return this.titleImovel
    }
    /**
    fun getIdImovel(): Int{
        return this.idImovel
    }

    fun getDescriptionImovel(): String{
        return this.descriptionImovel
    }

    fun getLocationImovel(): String{
        return this.locationImovel
    }

    fun getTypeImovel(): String{
        return this.typeImovel
    }

    fun getStatusImove(): Boolean{
        return this.statusImovel
    }
    */
    fun getImagemImovel(): Int{
        return this.imagemImovel
    }

    fun getReviewId(): Int{
        return this.reviewId
    }

    fun getPriceImovel(): String{
        return this.priceImovel
    }
}