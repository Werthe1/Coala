package space.jiyun.coala.util

import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * Ext functions AppCompatActivity.
 */

fun AppCompatActivity.setupActionBar(@IdRes id: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(id))

    supportActionBar?.run {
        action()
    }
}
