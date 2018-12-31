package space.jiyun.coala.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import space.jiyun.coala.R
import space.jiyun.coala.databinding.MypageActivityBinding
import space.jiyun.coala.util.setupActionBar

class MyPageActivity : AppCompatActivity() {

    private lateinit var binding: MypageActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mypage_activity)

        setupActionBar(R.id.toolbar_mp) {
            setDisplayShowTitleEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            elevation = 3f
        }
    }
}
