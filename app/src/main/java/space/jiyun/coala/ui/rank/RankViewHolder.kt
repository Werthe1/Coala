package space.jiyun.coala.ui.rank

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import space.jiyun.coala.data.User
import space.jiyun.coala.databinding.RankItemBinding

class RankViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val binding : RankItemBinding? = DataBindingUtil.bind(itemView)

    fun getClickObserver(item : User) : Observable<User> =
            Observable.create { emitter ->
                itemView.setOnClickListener {
                    emitter.onNext(item)
                }
            }
}