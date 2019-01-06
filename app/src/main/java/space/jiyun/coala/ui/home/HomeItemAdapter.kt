package space.jiyun.coala.ui.home

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import space.jiyun.coala.R
import space.jiyun.coala.data.Answer
import space.jiyun.coala.data.Question
import space.jiyun.coala.ui.answer.AnswerItemHeaderViewHolder

class HomeItemAdapter(val dataSet: OrderedRealmCollection<Question>, autoUpdate: Boolean)
    : RealmRecyclerViewAdapter<Question, RecyclerView.ViewHolder>(dataSet, autoUpdate) {

    val clickSubject = PublishSubject.create<Question>()

    private val headerView = 0
    private val contentView = 1

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> 0
            5 -> 0
            else -> 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                0 -> HomeItemHeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item_header, parent, false))
                1 -> HomeItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false))
                else -> HomeItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false))
            }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataSet[position]

        when (holder) {
            is HomeItemViewHolder -> {
                with(holder) {
                    binding?.question = item
                    binding?.viewmodel = HomeItemViewModel(item)

                    getClickObservable(item).subscribe(clickSubject)
                }
            }

            is HomeItemHeaderViewHolder -> holder.binding?.position = position
        }
    }


    override fun getItemCount(): Int = dataSet.size
}