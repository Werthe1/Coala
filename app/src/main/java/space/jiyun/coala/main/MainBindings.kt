package space.jiyun.coala.main

import androidx.annotation.IdRes
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


@BindingAdapter("selectedItemPosition")
fun setSelectedItemPosition(view : BottomNavigationView, @IdRes itemId : Int) {
    view.selectedItemId = itemId
}