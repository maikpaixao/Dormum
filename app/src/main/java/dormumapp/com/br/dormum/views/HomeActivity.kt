package dormumapp.com.br.dormum.views

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity;
import dormumapp.com.br.dormum.R
import kotlinx.android.synthetic.main.menu_botton_layout.*
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.support.design.internal.BottomNavigationMenuView
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import dormumapp.com.br.dormum.R.id.*
import kotlinx.android.synthetic.main.content_home.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.utils.CustomAdapterAlternative
import java.io.IOException
import java.io.InputStream
import java.net.URL
import android.os.StrictMode


class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = bottom_nav_view as BottomNavigationView
        removeNavigationShiftMode(bottomNavigationView)

        var listaImoveis = ArrayList<Imovel>()

        var query: ParseQuery<ParseObject> = ParseQuery.getQuery("Imoveis")

        query.findInBackground(){obj,e->
            var itera = obj.iterator()
            var listaImoveis = ArrayList<Imovel>()

            itera.forEach {
                var arq = it.getParseFile("imgImovel") as ParseFile
                var bmap = getBitmapFromURL(arq.url) as Bitmap

                var imovel_1   = Imovel(it.getString("tituloImovel").toString(), bmap, R.drawable.review, "R$ - 250")
                listaImoveis.add(imovel_1)
            }
            rview2.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            rview2.adapter = CustomAdapterAlternative(listaImoveis, this@HomeActivity)
        }

        // Click on profile image goes to profile
        imageView3.setOnClickListener(){
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        val builder = AlertDialog.Builder(this@HomeActivity)
        builder.setTitle("Mapas")
        builder.setMessage("Bug Found!")


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                home_btn ->
                    startActivity(Intent(this, HomeActivity::class.java))
                buscar_btn ->
                    startActivity(Intent(this, SearchActivity::class.java))
                alugar_btn ->
                    startActivity(Intent(this, ImovelActivity::class.java))
                mapa_btn ->
                    //No Map Activity
                    builder.create()
                profile_btn ->
                    startActivity(Intent(this, ProfileActivity::class.java))
            }
            true

        }
    }

    @SuppressLint("RestrictedApi")
    fun removeNavigationShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        menuView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        menuView.buildMenuView()
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
