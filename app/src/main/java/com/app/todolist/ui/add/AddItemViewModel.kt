package com.app.todolist.ui.add

import androidx.lifecycle.ViewModel
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.di.DaggerUtils

class AddItemViewModel : ViewModel() {

    private val toDoRepository = DaggerUtils.appComponent.provideToDoRepository()

    fun save(text: String) {
        toDoRepository.addItem(ToDoItem(text))
    }

}