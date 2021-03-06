package space.jiyun.coala.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import space.jiyun.coala.R
import space.jiyun.coala.data.addUser
import space.jiyun.coala.databinding.MainActivityBinding
import space.jiyun.coala.ui.mypage.MyPageActivity
import space.jiyun.coala.ui.rank.RankActivity
import space.jiyun.coala.util.setupActionBar

class MainActivity : AppCompatActivity(), MainNavigator {

    private lateinit var binding: MainActivityBinding

    private val mViewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.viewmodel = mViewModel

        setupActionBar(R.id.toolbar_main) {
            setDisplayShowTitleEnabled(false)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.menu_mypage -> {
                    startActivity(Intent(this, MyPageActivity::class.java))
                    true
                }
                R.id.menu_rank -> {
                    startActivity(Intent(this, RankActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }


    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
    }

}

