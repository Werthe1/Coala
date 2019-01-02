package space.jiyun.coala.main

import android.view.MenuItem
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import space.jiyun.coala.R
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