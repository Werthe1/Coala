package space.jiyun.coala.ui.answer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import space.jiyun.coala.R
import space.jiyun.coala.data.Answer


class AnswerItemAdapter(val dataSet: OrderedRealmCollection<Answer>, autoUpdate: Boolean)
    : RealmRecyclerViewAdapter<Answer, RecyclerView.ViewHolder>(dataSet, autoUpdate) {

    val clickSubject = PublishSubject.create<Answer>()

    private val headerView = 0
    private val contentView = 1


    override fun getItemViewType(position: Int): Int {
        val item = dataSet[position]

        return when {
            position == 0 -> 0
            position - 1 >= 0 -> {
                if (item.isAdopted && !dataSet[position - 1].isAdopted) 0 else 1
            }
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                0 -> AnswerItemHeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.answer_item_header, parent, false))
                1 -> AnswerItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.answer_item, parent, false))
                else -> AnswerItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.answer_item, parent, false))
            }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataSet[position]

        when(holder) {
            is AnswerItemViewHolder -> {
                holder.binding?.answer = item
                holder.getClickObservable(item).subscribe(clickSubject)
            }

            is AnswerItemHeaderViewHolder -> holder.binding?.position = position
        }
    }


    override fun getItemCount(): Int = dataSet.size
}