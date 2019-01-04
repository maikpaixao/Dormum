package dormumapp.com.br.dormum.views

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity;
import dormumapp.com.br.dormum.R
import dormumapp.com.br.dormum.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.menu_botton_layout.*
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.support.design.internal.BottomNavigationMenuView
import android.annotation.SuppressLint
import android.content.Intent
import dormumapp.com.br.dormum.R.id.*
import dormumapp.com.br.dormum.models.Usuario
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.content_home.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import dormumapp.com.br.dormum.models.Imovel
import dormumapp.com.br.dormum.utils.CustomAdapter
import dormumapp.com.br.dormum.utils.CustomAdapterAlternative
import kotlinx.android.synthetic.main.custom_item.*


class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = bottom_nav_view as BottomNavigationView
        removeNavigationShiftMode(bottomNavigationView)
        //BottomNavigationViewHelper.removeShiftMode(bottomNavigationView)

        var imagem: ImageView = resources.getDrawable(R.drawable.img_homem) as ImageView

        var imovel_1: Imovel = Imovel("1 Aluguel de Apartamento com 3 quartos e uma vaga no Recife.", R.drawable.room, R.drawable.review, "R$ - 250")
        var imovel_2: Imovel = Imovel("2 Aluguel de Apartamento com 3 quartos e uma vaga no Recife.", R.drawable.room2, R.drawable.review,"R$ - 250")
        var imovel_3: Imovel = Imovel("3 Aluguel de Apartamento com 3 quartos e uma vaga no Recife.", R.drawable.room, R.drawable.review,"R$ - 250")

        var listaImoveis = ArrayList<Imovel>()
        listaImoveis.add(imovel_1)
        listaImoveis.add(imovel_2)
        listaImoveis.add(imovel_3)

        rview.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rview.adapter = CustomAdapter(listaImoveis, this)

        rview2.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rview2.adapter = CustomAdapterAlternative(listaImoveis, this)

        rview3.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rview3.adapter = CustomAdapter(listaImoveis, this)

        // Click on profile image goes to profile
        imageView3.setOnClickListener(){
            startActivity(Intent(this, ProfileActivity::class.java))
        }


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                home_btn ->
                    startActivity(Intent(this, HomeActivity::class.java))
                buscar_btn ->
                    startActivity(Intent(this, SearchActivity::class.java))
                alugar_btn ->
                    startActivity(Intent(this, ImovelActivity::class.java))
                mapa_btn ->
                    startActivity(Intent(this, ChatActivity::class.java))
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


}
