package space.jiyun.coala.ui.writequestion

import android.graphics.Color
import androidx.databinding.BindingAdapter
import co.lujun.androidtagview.TagContainerLayout
import co.lujun.androidtagview.TagView
import space.jiyun.coala.R

@BindingAdapter("setTags")
fun setTags(view: TagContainerLayout, tags: MutableList<String>) {
    view.tags = tags
}

@BindingAdapter("setOnTagClickListener")
fun setOnTagClickListener(view: TagContainerLayout, valid: Boolean) {
    if (valid && view.id == R.id.tag_wq) {
        view.setOnTagClickListener(object : TagView.OnTagClickListener {
            override fun onTagCrossClick(position: Int) {
                view.removeTag(position)
            }

            override fun onSelectedTagDrag(position: Int, text: String) {
            }

            override fun onTagLongClick(position: Int, text: String) {
            }

            override fun onTagClick(position: Int, text: String) {
            }
        })
    }
}