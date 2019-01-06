package space.jiyun.coala.ui.question

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import io.reactivex.subjects.PublishSubject
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import space.jiyun.coala.R
import space.jiyun.coala.data.Question

class QuestionItemAdapter(val dataSet: OrderedRealmCollection<Question>, autoUpdate: Boolean)
    : RealmRecyclerViewAdapter<Question, QuestionItemViewHolder>(dataSet, autoUpdate) {

    val clickSubject = PublishSubject.create<Question>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionItemViewHolder =
            QuestionItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.question_item, parent, false))


    override fun onBindViewHolder(holder: QuestionItemViewHolder, position: Int) {
        val item = dataSet[position]

        with(holder) {
            binding?.let {
                it.question = item
                it.viewmodel = QuestionItemViewModel(item)
            }
            getClickObservable(item).subscribe(clickSubject)
        }
    }


    override fun getItemCount(): Int = dataSet.size
}