package space.jiyun.coala.ui.writequestion

import android.app.Application
import android.util.Log
import android.view.View
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import co.lujun.androidtagview.TagContainerLayout
import co.lujun.androidtagview.TagView


class WriteQuestionViewModel(val context : Application) : AndroidViewModel(context) {

    var navigator : WriteQuestionNavigator?=null
    val tags = ObservableArrayList<String>()


    fun onAddTagClick() {
        navigator?.addTag()
    }


}