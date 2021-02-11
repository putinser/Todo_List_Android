package com.app.todolist.data.repository.todo

import androidx.lifecycle.MutableLiveData
import com.app.todolist.data.model.ToDoItem

interface IToDoRepository {

    fun getToDoLiveData(): MutableLiveData<List<ToDoItem>>

    suspend fun addItem(toDoItem: ToDoItem)

    suspend fun update(toDoItem: ToDoItem)

    suspend fun remove(toDoItem: ToDoItem, position: Int)
}