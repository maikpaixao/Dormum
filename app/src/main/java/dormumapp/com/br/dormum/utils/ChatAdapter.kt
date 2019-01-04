package dormumapp.com.br.dormum.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.ChatBase
import kotlinx.android.synthetic.main.custom_chat_list.view.*
import java.util.*

class ChatAdapter(val lista: ArrayList<ChatBase>, val context: Context): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_chat_list, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val chat = lista.get(p1)
        p0?.nameChat.text = chat.getUsuarioChat()
        p0?.msgChat.text = chat.getMessageChat()
        p0?.ImagemChat.setImageResource(chat.getImageChat())
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nameChat = itemView.chat_name
        var ImagemChat = itemView.chat_image
        var msgChat = itemView.chat_message
    }

}