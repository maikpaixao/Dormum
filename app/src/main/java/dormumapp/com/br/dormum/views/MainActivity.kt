package dormumapp.com.br.dormum.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dormumapp.com.br.dormum.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_main.setOnClickListener(){
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}
