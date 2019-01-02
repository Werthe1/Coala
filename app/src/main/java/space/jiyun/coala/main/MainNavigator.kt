package space.jiyun.coala.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface MainNavigator {

    fun replaceFragment(fragment : Fragment)
}