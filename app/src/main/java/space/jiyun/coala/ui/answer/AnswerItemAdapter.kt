package space.jiyun.coala.ui.answer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import space.jiyun.coala.R
import space.jiyun.coala.data.Answer
import space.jiyun.coala.ui.answer.AnswerItemViewHolder


class AnswerItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataSet = mutableListOf<Answer>()
    val clickSubject = PublishSubject.create<Answer>()

    private val headerView = 0
    private val contentView = 1

    fun updateItems(items: MutableList<Answer>) {
        with(dataSet) {
            clear()
            addAll(items)
            sortBy { it -> it.isAdopted }
        }

        notifyItemRangeInserted(0, items.size)
    }

    fun addItem(item: Answer) {
        with(dataSet) {
            add(item)
            sortBy { it -> it.isAdopted }
        }

        notifyItemInserted(dataSet.size - 1)
    }

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
                0 -> AnsweritemHeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.answer_item_header, parent, false))
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

            is AnsweritemHeaderViewHolder -> holder.binding?.position = position
        }
    }


    override fun getItemCount(): Int = dataSet.size
}