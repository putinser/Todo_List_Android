package com.app.todolist.ui.add

import androidx.lifecycle.ViewModel
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.di.DaggerUtils

class AddItemViewModel : ViewModel() {

    private val toDoInteractor = DaggerUtils.appComponent.provideToDoInteractor()

    fun save(text: String) {
        toDoInteractor.addItem(ToDoItem(text))
    }

}