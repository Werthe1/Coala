package space.jiyun.coala.ui.writequestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import co.lujun.androidtagview.TagView
import space.jiyun.coala.R
import space.jiyun.coala.databinding.WriteQuestionActivityBinding
import space.jiyun.coala.util.setupActionBar

class WriteQuestionActivity : AppCompatActivity(), WriteQuestionNavigator {

    private lateinit var binding: WriteQuestionActivityBinding
    private lateinit var viewModel: WriteQuestionViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.write_question_activity)

        viewModel = ViewModelProviders.of(this).get(WriteQuestionViewModel::class.java).apply {
            navigator = this@WriteQuestionActivity
        }

        binding.viewmodel = viewModel

        setupActionBar(R.id.toolbar_write) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
            elevation = 3f
        }
    }


    override fun addTag() {
        val inputTag = binding.editWqTag.text

        if (!inputTag.isNullOrEmpty()) {
            if (!viewModel.tags.contains(inputTag.toString())) {
                viewModel.tags.add(inputTag.toString().toLowerCase())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_write, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.menu_enroll -> {
                    finish()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

}
