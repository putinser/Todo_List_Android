package com.app.todolist.di.app

import com.app.todolist.interactor.ToDoInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideToDoInteractor(): ToDoInteractor = ToDoInteractor()
}