package dormumapp.com.br.dormum.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.StrictMode
import java.io.IOException
import java.io.InputStream
import java.net.URL

class BitmapUrl{

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