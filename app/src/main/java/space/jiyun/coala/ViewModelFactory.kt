package space.jiyun.coala

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import space.jiyun.coala.ui.home.HomeViewModel
import space.jiyun.coala.ui.writequestion.WriteQuestionNavigator
import space.jiyun.coala.ui.writequestion.WriteQuestionViewModel

class ViewModelFactory private constructor(
        private val application: Application
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(HomeViewModel::class.java) ->
                        HomeViewModel(application)
                    isAssignableFrom(WriteQuestionViewModel::class.java) ->
                        WriteQuestionViewModel(application)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T


}