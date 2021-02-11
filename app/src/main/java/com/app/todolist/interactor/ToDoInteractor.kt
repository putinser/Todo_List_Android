package com.app.todolist.interactor

import androidx.lifecycle.MutableLiveData
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.di.DaggerUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoInteractor {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val toDoRepository = DaggerUtils.appComponent.provideToDoRepository()

    fun getToDoLiveData(): MutableLiveData<List<ToDoItem>> {
        return toDoRepository.getToDoLiveData()
    }

    fun addItem(toDoItem: ToDoItem) {
        scope.launch {
            toDoRepository.addItem(toDoItem)
        }
    }

    fun update(toDoItem: ToDoItem) {
        scope.launch {
            toDoRepository.update(toDoItem)
        }
    }

    fun remove(toDoItem: ToDoItem, position: Int) {
        scope.launch {
            toDoRepository.remove(toDoItem, position)
        }
    }
}