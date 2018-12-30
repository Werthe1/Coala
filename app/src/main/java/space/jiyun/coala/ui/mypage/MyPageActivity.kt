package space.jiyun.coala.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import space.jiyun.coala.R
import space.jiyun.coala.databinding.MypageActivityBinding

class MyPageActivity : AppCompatActivity() {

    private lateinit var binding: MypageActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mypage_activity)
    }
}
