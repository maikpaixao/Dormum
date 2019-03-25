package dormumapp.com.br.dormum.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import dormumapp.com.br.dormum.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        edit_profile_id.setOnClickListener(){
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

    }

}
