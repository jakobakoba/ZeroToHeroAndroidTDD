package ru.easycode.zerotoheroandroidtdd

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Screen {
    abstract fun show(supportFragmentManager: FragmentManager, containerId: Int)

    abstract class Replace(private val fragmentClass: Class<out Fragment>): Screen {
        override fun show(supportFragmentManager: FragmentManager, containerId: Int) {
            supportFragmentManager.beginTransaction()
                .replace(containerId, fragmentClass.getDeclaredConstructor().newInstance())
                .commit()
        }
    }

}