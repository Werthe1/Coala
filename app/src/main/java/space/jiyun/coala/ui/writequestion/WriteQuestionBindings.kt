package space.jiyun.coala.ui.writequestion

import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import co.lujun.androidtagview.TagContainerLayout
import co.lujun.androidtagview.TagView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import space.jiyun.coala.R
import space.jiyun.coala.util.GlideApp


@BindingAdapter("uri")
fun setImageUri(view: ImageView, uri: String?) {
    GlideApp
            .with(view.context)
            .load(uri)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .thumbnail(0.1f)
            .into(view)
}


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