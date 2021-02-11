package com.app.todolist.utils.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun Fragment.addFragment(containerId: Int, fragment: Fragment) {
    fragmentManager?.let { fm ->
        fm
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .add(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }
}

fun Fragment.dismiss() {
    fragmentManager?.popBackStack()
}