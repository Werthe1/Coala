package space.jiyun.coala.ui.rank

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import space.jiyun.coala.R
import space.jiyun.coala.data.User

class RankAdapter() : RecyclerView.Adapter<RankViewHolder>() {

    private val dataSet = mutableListOf<User>()
    val clickSubject = PublishSubject.create<User>()

    fun addItems(items : MutableList<User>) {
        dataSet.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder =
            RankViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rank_item, parent, false))


    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        val item = dataSet[position]

        holder.binding?.user = item
        holder.getClickObserver(item).subscribe(clickSubject)
    }


    override fun getItemCount(): Int = dataSet.size

}