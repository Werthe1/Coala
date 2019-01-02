package space.jiyun.coala.ui.home

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import space.jiyun.coala.data.Question
import space.jiyun.coala.databinding.HomeItemBinding
import space.jiyun.coala.databinding.HomeItemHeaderBinding

class HomeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: HomeItemBinding? = DataBindingUtil.bind(itemView)

    fun getClickObservable(item: Question): Observable<Question> =
            Observable.create { emitter ->
                itemView.setOnClickListener {
                    emitter.onNext(item)
                }
            }
}