package com.app.todolist.ui.list

import androidx.lifecycle.ViewModel
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.di.DaggerUtils

class ListViewModel : ViewModel() {

    private val toDoRepository = DaggerUtils.appComponent.provideToDoRepository()

    fun getToDoLiveData() = toDoRepository.getToDoLiveData()

    fun update(toDoItem: ToDoItem) {
        toDoRepository.update(toDoItem)
    }

    fun remove(toDoItem: ToDoItem, position: Int) {
        toDoRepository.remove(toDoItem, position)
    }
}