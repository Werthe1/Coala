package space.jiyun.coala.ui.home

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import space.jiyun.coala.ui.writequestion.WriteQuestionActivity

class HomeViewModel(private val context  : Application) : AndroidViewModel(context) {


    /**
     * Click writeQuestion FAB.
     */
    fun onWriteQuestionClick() {
        context.startActivity(Intent(context.applicationContext, WriteQuestionActivity::class.java))
    }
}
