package space.jiyun.coala

import android.app.Application
import com.bumptech.glide.Glide
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm

class CoalaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Glide.with(this)
        Realm.init(this)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                RealmInspectorModulesProvider.builder(this).build())
                        .build())
    }

}