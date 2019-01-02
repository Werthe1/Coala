package space.jiyun.coala.ui.question

import androidx.databinding.ObservableField
import space.jiyun.coala.data.Question

class QuestionItemViewModel(val question : Question) {

    val isLike = ObservableField<Boolean>(question.isLike)

    fun onLikeClick() {
        question.isLike = !question.isLike
        isLike.set(question.isLike)
    }
}