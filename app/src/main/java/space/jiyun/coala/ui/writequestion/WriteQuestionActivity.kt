package space.jiyun.coala.ui.writequestion

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.request.RequestOptions
import gun0912.tedbottompicker.TedBottomPicker
import io.realm.Realm
import io.realm.RealmList
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import space.jiyun.coala.R
import space.jiyun.coala.data.Question
import space.jiyun.coala.data.Tag
import space.jiyun.coala.data.User
import space.jiyun.coala.databinding.WriteQuestionActivityBinding
import space.jiyun.coala.util.GlideApp
import space.jiyun.coala.util.setupActionBar
import java.util.*

class WriteQuestionActivity : AppCompatActivity(), WriteQuestionNavigator {

    private lateinit var binding: WriteQuestionActivityBinding
    private lateinit var viewModel: WriteQuestionViewModel

    private val storagePermissionCode = 1
    private val realm = Realm.getDefaultInstance()

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


    override fun openImagePicker(position: Int) {
        checkStorageAccessPermission()

        TedBottomPicker.Builder(this)
                .setOnImageSelectedListener {
                    viewModel.setImgUri(position, it.toString())
                }
                .setImageProvider { imageView, imageUri ->
                    GlideApp
                            .with(this)
                            .load(imageUri)
                            .thumbnail(0.1f)
                            .apply(RequestOptions().centerCrop())
                            .into(imageView)
                }
                .setPreviewMaxCount(7)
                .create()
                .show(supportFragmentManager)
    }


    private fun checkStorageAccessPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  // >= 23
            val requestPermission = Manifest.permission.WRITE_EXTERNAL_STORAGE

            ContextCompat.checkSelfPermission(this, requestPermission).run {

                if (this != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this@WriteQuestionActivity,
                            arrayOf(requestPermission), storagePermissionCode)
                }
            }
        }
    }

    private fun createQuestion() {
        realm.executeTransaction { r ->
            val question  = r.createObject<Question>(UUID.randomUUID().toString())

            with(question) {
                writer = "이지윤"
                title = binding.editWqTitle.text.toString()
                content = binding.editWqContent.text.toString()
                date = Date()

                for(item in binding.tagWq.tags.iterator()) {
                    val tag = r.createObject<Tag>()
                    tag.name = item
                    this.tags.add(tag)
                }
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
                    createQuestion()
                    finish()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, results: IntArray) {
        if (results.isNotEmpty() && results[0] == PackageManager.PERMISSION_GRANTED) {
            when (requestCode) {
                storagePermissionCode -> return
                else -> super.onRequestPermissionsResult(requestCode, permissions, results)
            }
        }
    }

    override fun onStop() {
        super.onStop()

        realm.close()
    }
}
