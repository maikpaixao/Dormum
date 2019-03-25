package dormumapp.com.br.dormum.utils

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.database.DataSetObserver
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.design.R.id.image
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import dormumapp.com.br.dormum.DetalhesActivity
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.R.id.view
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.views.HomeActivity
import dormumapp.com.br.dormum.views.LoginActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_item2.view.*

class CustomAdapterAlternative (val imoveis: List<Imovel>, val context: Context) : RecyclerView.Adapter <CustomAdapterAlternative.ViewHolder>() {

    var onItemClick: ((Imovel) -> Unit)? = null
    var activity: Context = context

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_item2, p0, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imoveis.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        val imovel = imoveis.get(p1)
        var draw: Drawable = BitmapDrawable(Resources.getSystem(), imovel.getImagemImovel())

        p0?.titleRoom.text = imovel.getTitleImovel()
        p0?.ImagemRoom.setImageDrawable(draw)
        p0?.priceRoom.text = imovel.getPriceImovel()
        p0?.reviewRoom.setImageResource(imovel.getReviewId())

        p0?.itemView.setOnClickListener(){
            System.out.println("ASHSASUHD ASUDHAS")
            context.startActivity(Intent(context, DetalhesActivity::class.java))
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var titleRoom = itemView.title_room_full_id
        var ImagemRoom = itemView.image_room_full_id
        var priceRoom = itemView.price_id
        var reviewRoom = itemView.review_id
    }



}