package space.jiyun.coala

import android.view.MenuItem
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

@BindingMethods(
        BindingMethod(
                type = BottomNavigationView::class,
                attribute = "app:onNavigationItemSelected",
                method = "setOnNavigationItemSelectedListener"
        )
)

class MainActViewModel : ViewModel() {

    fun onNavigationItemClicked(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.navigation_myquestion -> {
                    true
                }
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_myanswer -> {
                    true
                }
                else -> {
                    true
                }
            }
}