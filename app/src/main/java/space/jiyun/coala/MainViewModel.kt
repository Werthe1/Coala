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

@BindingMethods(
        BindingMethod(
                type = BottomNavigationView::class,
                attribute = "app:onNavigationItemSelected",
                method = "setOnNavigationItemSelectedListener"
        )
)


class MainViewModel(private val navigator: MainNavigator) : ViewModel() {

    fun onNavigationItemClicked(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.navigation_myquestion -> {
                   navigator.replaceFragment(QuestionFragment.newInstance())
                    true
                }
                R.id.navigation_home -> {
                    navigator.replaceFragment(HomeFragment.newInstance())
                    true
                }
                R.id.navigation_myanswer -> {
                    navigator.replaceFragment(AnswerFragment.newInstance())
                    true
                }
               else -> {
                   false
               }
            }
}