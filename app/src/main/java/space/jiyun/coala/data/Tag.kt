package space.jiyun.coala.data

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Tag : RealmModel {
    var name : String =""

    @LinkingObjects("tags")
    val questions : RealmResults<Question>?= null
}