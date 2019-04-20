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
import dormumapp.com.br.dormum.R.id.*
import kotlinx.android.synthetic.main.content_home.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dormumapp.com.br.dormum.utils.CustomAdapterAlternative
import dormumapp.com.br.dormum.controllers.ControllerImovel


class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = bottom_nav_view as BottomNavigationView
        removeNavigationShiftMode(bottomNavigationView)

        var db = ControllerImovel()
        var listaImoveis = db.listarImoveis()

        rview2.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
        rview2.adapter = CustomAdapterAlternative(listaImoveis, this@HomeActivity)

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
}
