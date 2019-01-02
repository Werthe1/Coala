package space.jiyun.coala.ui.answer

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import space.jiyun.coala.data.Answer
import space.jiyun.coala.databinding.AnswerItemBinding

class AnswerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: AnswerItemBinding? = DataBindingUtil.bind(itemView)

    fun getClickObservable(item: Answer): Observable<Answer> =
            Observable.create { emitter ->
                itemView.setOnClickListener {
                    emitter.onNext(item)
                }
            }
}