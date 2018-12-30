package space.jiyun.coala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import space.jiyun.coala.databinding.MainActivityBinding

import space.jiyun.coala.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding

    private val mViewModel = MainActViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.viewmodel = mViewModel


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
