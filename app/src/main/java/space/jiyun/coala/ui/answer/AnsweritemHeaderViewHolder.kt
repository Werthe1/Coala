package space.jiyun.coala.ui.answer

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import space.jiyun.coala.databinding.AnswerItemHeaderBinding

class AnsweritemHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: AnswerItemHeaderBinding? = DataBindingUtil.bind(itemView)

}