package space.jiyun.coala.data

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Answer : RealmModel {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()

    var title: String = ""

    var writer: String = ""

    var content: String = ""

    var date: Date? = null

    var like: Int = 0

    @LinkingObjects("answers")
    val question: RealmResults<Question>? = null

    var isAdopted: Boolean = false
}