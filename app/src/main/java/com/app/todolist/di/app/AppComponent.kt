package com.app.todolist.di.app

import com.app.todolist.data.db.dao.ToDoDao
import com.app.todolist.data.repository.todo.IToDoRepository
import com.app.todolist.interactor.ToDoInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface AppComponent {

    fun provideToDoRepository(): IToDoRepository

    fun providesToDoDao(): ToDoDao

    fun provideToDoInteractor(): ToDoInteractor

}