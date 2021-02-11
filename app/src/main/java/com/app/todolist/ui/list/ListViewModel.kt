package com.app.todolist.ui.list

import androidx.lifecycle.ViewModel
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.di.DaggerUtils

class ListViewModel : ViewModel() {

    private val toDoInteractor = DaggerUtils.appComponent.provideToDoInteractor()

    fun getToDoLiveData() = toDoInteractor.getToDoLiveData()

    fun update(toDoItem: ToDoItem) {
        toDoInteractor.update(toDoItem)
    }

    fun remove(toDoItem: ToDoItem, position: Int) {
        toDoInteractor.remove(toDoItem, position)
    }
}