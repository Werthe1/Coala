package space.jiyun.coala

import android.app.Application
import com.bumptech.glide.Glide

class CoalaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Glide.with(this)
    }

}