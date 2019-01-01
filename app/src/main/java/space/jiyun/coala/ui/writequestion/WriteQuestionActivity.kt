package space.jiyun.coala.ui.writequestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import space.jiyun.coala.R
import space.jiyun.coala.databinding.WriteQuestionActivityBinding
import space.jiyun.coala.util.setupActionBar

class WriteQuestionActivity : AppCompatActivity() {

    private lateinit var binding: WriteQuestionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.write_question_activity)


        setupActionBar(R.id.toolbar_write) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
            elevation = 3f
        }
    }
}
