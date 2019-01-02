package space.jiyun.coala.ui.question

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import space.jiyun.coala.R
import space.jiyun.coala.data.Question

class QuestionItemAdapter : RecyclerView.Adapter<QuestionItemViewHolder>() {

    private val dataSet = mutableListOf<Question>()
    val clickSubject = PublishSubject.create<Question>()


    fun updateItems(items : MutableList<Question>) {
        with(dataSet) {
            clear()
            addAll(items)
        }

        notifyItemRangeInserted(0, items.size)
    }

    fun addItem(item : Question) {
        dataSet.add(item)

        notifyItemInserted(dataSet.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionItemViewHolder=
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


    override fun getItemCount(): Int =dataSet.size
}