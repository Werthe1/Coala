package space.jiyun.coala.ui.writequestion

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.databinding.ObservableField


class WriteQuestionViewModel(val context: Application) : AndroidViewModel(context) {

    var navigator: WriteQuestionNavigator? = null
    val tags = ObservableArrayList<String>()

    val imgUri1 = ObservableField<String>()
    val imgUri2 = ObservableField<String>()
    val imgUri3 = ObservableField<String>()


    fun onAddTagClick() {
        navigator?.addTag()
    }

    fun onDeleteImgClick(position: Int) {
        when (position) {
            1 -> imgUri1.set(null)
            2 -> imgUri2.set(null)
            3 -> imgUri3.set(null)
        }
    }

    fun onSelectImgClick(position: Int) {
        navigator?.openImagePicker(position)
    }

    fun setImgUri(position: Int, uri: String) {
        when (position) {
            1 -> imgUri1.set(uri)
            2 -> imgUri2.set(uri)
            3 -> imgUri3.set(uri)
        }
    }


}