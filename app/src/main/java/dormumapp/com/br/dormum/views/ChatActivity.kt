package dormumapp.com.br.dormum.views

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.ChatBase
import dormumapp.com.br.dormum.models.Usuario
import dormumapp.com.br.dormum.utils.ChatAdapter
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.content_home.*
import java.time.LocalDate
import java.time.LocalDate.of
import java.util.*
import kotlin.collections.ArrayList

class ChatActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        var listaChat = ArrayList<ChatBase>()

        //var date = of(2018, 12, 31)
        //var usuario = Usuario("Maikao", "senha", "Maik Paixão",  111, date, "masculino", "rua", 987,"recife")

        var chat1 = ChatBase("Maik Luiz Paixão", "minha mensagem minha mensagem minha mensagem minha mensagem minha mensagem", R.drawable.img_homem)
        var chat2 = ChatBase("Maik Luiz Paixão", "minha mensagem minha mensagem minha mensagem minha mensagem minha mensagem", R.drawable.img_homem)
        var chat3 = ChatBase("Maik Luiz Paixão", "minha mensagem minha mensagem minha mensagem minha mensagem minha mensagem", R.drawable.img_homem)
        var chat4 = ChatBase("Maik Luiz Paixão", "minha mensagem minha mensagem minha mensagem minha mensagem minha mensagem", R.drawable.img_homem)
        var chat5 = ChatBase("Maik Luiz Paixão", "minha mensagem minha mensagem minha mensagem minha mensagem minha mensagem", R.drawable.img_homem)
        var chat6 = ChatBase("Maik Luiz Paixão", "minha mensagem minha mensagem minha mensagem minha mensagem minha mensagem", R.drawable.img_homem)

        listaChat.add(chat1)
        listaChat.add(chat2)
        listaChat.add(chat3)
        listaChat.add(chat4)
        listaChat.add(chat5)
        listaChat.add(chat6)

        r_chat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        r_chat.adapter = ChatAdapter(listaChat, this)

        r_chat.setOnClickListener(){
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }


}
