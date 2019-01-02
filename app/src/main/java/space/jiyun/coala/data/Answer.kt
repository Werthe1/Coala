package space.jiyun.coala.data

import java.util.*

data class Answer(
        val id : Int =0,
        val title : String="",
        val writer : String,
        val content : String,
        var date: Date? = null,
        var isAdopted : Boolean = false,
        val like : Int =0
)