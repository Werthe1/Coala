package space.jiyun.coala.data

import androidx.databinding.ObservableField
import java.util.*

data class Question(
        val id: Int = 0,
        var title: String = "",
        val writer: String = "",
        var content: String = "",
        var date: Date? = null,
        var answer: Int = 0,
        var isLike : Boolean = false,
        var like: Int = 0) {

    val tag: List<String> = listOf()
    val photos: List<String> = listOf()
}