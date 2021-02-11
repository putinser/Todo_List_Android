package com.app.todolist.utils.extensions

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

fun RecyclerView.attachFab(fab : FloatingActionButton) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0)
                fab.hide()
            else if (dy < 0)
                fab.show()
        }
    })
}