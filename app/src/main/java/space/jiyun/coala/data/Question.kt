package space.jiyun.coala.data

import androidx.databinding.ObservableField
import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Question : RealmModel {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()

    var title: String = ""

    var writer: String = ""

    var content: String = ""

    var date: Date? = null

    //one-to-many
    var answers: RealmList<Answer> = RealmList()

    @Ignore
    var isLike = false

    var like: Int = 0

    var tags: RealmList<Tag> = RealmList()
    var photos: RealmList<String> = RealmList()
}