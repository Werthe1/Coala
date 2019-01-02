package space.jiyun.coala.ui.home

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import space.jiyun.coala.databinding.AnswerItemHeaderBinding
import space.jiyun.coala.databinding.HomeItemHeaderBinding

class HomeItemHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: HomeItemHeaderBinding? = DataBindingUtil.bind(itemView)
}