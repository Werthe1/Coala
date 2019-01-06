package space.jiyun.coala.ui.rank

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import space.jiyun.coala.util.GlideApp


@BindingAdapter("uri")
fun setRankImg(view : ImageView, uri : String) {
    GlideApp
            .with(view)
            .load(uri)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
}
