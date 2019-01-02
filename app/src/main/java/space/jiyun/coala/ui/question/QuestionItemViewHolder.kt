package space.jiyun.coala.ui.question

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import space.jiyun.coala.data.Question
import space.jiyun.coala.databinding.QuestionItemBinding

class QuestionItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: QuestionItemBinding? = DataBindingUtil.bind(itemView)

    fun getClickObservable(item: Question): Observable<Question> =
            Observable.create { emitter ->
                itemView.setOnClickListener {
                    emitter.onNext(item)
                }
            }
}