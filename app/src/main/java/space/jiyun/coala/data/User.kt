package space.jiyun.coala.data

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class User (
        @PrimaryKey
        var id : String = UUID.randomUUID().toString(),

        var name : String = "",
        var rank : Long = 0,
        var coin : String="",
        var profile : String?=null,

        var questions : RealmList<Question> = RealmList(),
        var answers : RealmList<Answer> =RealmList(),
        var likeQuestions : RealmList<Question> = RealmList()
) : RealmModel