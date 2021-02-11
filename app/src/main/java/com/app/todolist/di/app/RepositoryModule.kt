package com.app.todolist.di.app

import com.app.todolist.data.repository.todo.IToDoRepository
import com.app.todolist.data.repository.todo.ToDoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule() {

    @Provides
    @Singleton
    fun provideToDoRepository(): IToDoRepository = ToDoRepository()

}