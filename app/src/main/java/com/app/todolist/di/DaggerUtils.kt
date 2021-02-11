package com.app.todolist.di

import android.content.Context
import com.app.todolist.di.app.*


object DaggerUtils {

    lateinit var appComponent: AppComponent

    @JvmStatic
    fun buildComponents(context: Context) {

        appComponent = buildAppComponent(context)
    }

    private fun buildAppComponent(context: Context) = DaggerAppComponent.builder()
        .appModule(AppModule())
        .roomModule(RoomModule(context))
        .repositoryModule(RepositoryModule())
        .build()
}