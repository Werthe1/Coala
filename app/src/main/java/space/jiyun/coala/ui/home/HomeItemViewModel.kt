package space.jiyun.coala.ui.home

import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR.question
import space.jiyun.coala.data.Question

class HomeItemViewModel(val question : Question){
    val isLike = ObservableField<Boolean>(question.isLike)

    fun onLikeClick() {
        question.isLike = !question.isLike
        isLike.set(question.isLike)
    }
}