package space.jiyun.coala.ui.writequestion

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentManager

interface WriteQuestionNavigator {

    fun addTag()

    fun openImagePicker(position : Int)
}