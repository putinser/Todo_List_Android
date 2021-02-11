package com.app.todolist.data.repository.todo

import androidx.lifecycle.MutableLiveData
import com.app.todolist.data.model.ToDoItem

interface IToDoRepository {

    fun getToDoLiveData(): MutableLiveData<List<ToDoItem>>

    fun addItem(toDoItem: ToDoItem)

    fun update(toDoItem: ToDoItem)

    fun remove(toDoItem: ToDoItem, position: Int)
}