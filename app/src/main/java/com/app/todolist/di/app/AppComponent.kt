package com.app.todolist.di.app

import com.app.todolist.data.db.dao.ToDoDao
import com.app.todolist.data.repository.todo.IToDoRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface AppComponent {

    fun provideToDoRepository(): IToDoRepository

    fun providesToDoDao(): ToDoDao

}