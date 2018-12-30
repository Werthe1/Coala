package space.jiyun.coala

import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import space.jiyun.coala.databinding.AnswerFragmentBinding
import space.jiyun.coala.ui.answer.AnswerFragment
import space.jiyun.coala.ui.home.HomeFragment
import space.jiyun.coala.ui.question.QuestionFragment

@BindingAdapter("selectedItemPosition")
fun setSelectedItemPosition(view : BottomNavigationView, @IdRes itemId : Int) {
    view.selectedItemId = itemId
}

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