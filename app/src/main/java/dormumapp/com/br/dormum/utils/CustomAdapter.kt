package dormumapp.com.br.dormum.utils

import android.content.Context
import android.database.DataSetObserver
import android.support.design.R.id.image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.models.Usuario
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_item.view.*

class CustomAdapter(val imoveis: List<Imovel>, val context: Context): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imoveis.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val imovel = imoveis.get(p1)
        p0?.titleRoom.text = imovel.getTitleImovel()
        p0?.ImagemRoom.setImageBitmap(imovel.getImagemImovel())
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleRoom = itemView.title_room_id
        var ImagemRoom = itemView.image_room_id
    }



}