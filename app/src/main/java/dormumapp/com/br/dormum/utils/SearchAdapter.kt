package dormumapp.com.br.dormum.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.Imovel
import kotlinx.android.synthetic.main.custom_item_search.view.*

class SearchAdapter(val imoveis: List<Imovel>, val context: Context): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val imovel = imoveis.get(p1)
        p0?.titleRoom.text = imovel.getTitleImovel()
        p0?.imageRoom.setImageBitmap(imovel.getImagemImovel())
        p0?.descRoom.text = imovel.getTitleImovel()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_item_search, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imoveis.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleRoom = itemView.title_room_search_id
        var imageRoom = itemView.image_room_search_id
        var descRoom = itemView.descricao_room_search_id
    }
}