package com.app.todolist.app

import android.app.Application
import android.content.Context
import com.app.todolist.di.DaggerUtils

class App : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        DaggerUtils.buildComponents(this)
    }

}