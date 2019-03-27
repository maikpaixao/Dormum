package dormumapp.com.br.dormum.views

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.SearchView
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.utils.SearchAdapter
import kotlinx.android.synthetic.main.activity_search.*
import java.io.IOException
import java.io.InputStream
import java.net.URL

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                var query: ParseQuery<ParseObject> = ParseQuery.getQuery("Imoveis")
                query.whereContains("tituloImovel", p0)

                query.findInBackground(){obj,e->
                    var itera = obj.iterator()
                    var listaImoveis = ArrayList<Imovel>()

                    itera.forEach {
                        var arq = it.getParseFile("imgImovel") as ParseFile
                        var bmap = getBitmapFromURL(arq.url) as Bitmap

                        var imovel_1   = Imovel(it.getString("tituloImovel").toString(), bmap, R.drawable.review, "R$ - 250")
                        listaImoveis.add(imovel_1)
                    }
                    search_list.layoutManager = LinearLayoutManager(this@SearchActivity, RecyclerView.VERTICAL, false)
                    search_list.adapter = SearchAdapter(listaImoveis, this@SearchActivity)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        //var query: ParseQuery<ParseObject> = ParseQuery.getQuery("Imoveis")
        //query.whereContains("tituloImovel", "sda")
    }

    fun getBitmapFromURL(src: String): Bitmap? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        try {
            val url = URL(src)
            val input = url.getContent() as InputStream
            return BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

    }
}
