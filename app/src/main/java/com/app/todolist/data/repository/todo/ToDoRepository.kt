package com.app.todolist.data.repository.todo

import androidx.lifecycle.MutableLiveData
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.di.DaggerUtils
import com.app.todolist.utils.extensions.notifyObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoRepository : IToDoRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val toDoDao = DaggerUtils.appComponent.providesToDoDao()

    private val toDoListLiveData = MutableLiveData<List<ToDoItem>>()

    init {
        scope.launch {
            val list = toDoDao.getAll()
            withContext(Dispatchers.Main) {
                toDoListLiveData.value = list
            }
        }
    }

    override fun getToDoLiveData(): MutableLiveData<List<ToDoItem>> {
        return toDoListLiveData
    }

    override fun addItem(toDoItem: ToDoItem) {
        scope.launch {
            toDoItem.id = toDoDao.getIdForRowId(toDoDao.insert(toDoItem))
            (toDoListLiveData.value as? ArrayList)?.add(toDoItem)
            withContext(Dispatchers.Main) {
                toDoListLiveData.notifyObserver()
            }
        }
    }

    override fun update(toDoItem: ToDoItem) {
        scope.launch {
            toDoDao.update(toDoItem)
        }
    }

    override fun remove(toDoItem: ToDoItem, position: Int) {
        scope.launch {
            toDoDao.delete(toDoItem)
        }
        (toDoListLiveData.value as? ArrayList)?.removeAt(position)
        toDoListLiveData.notifyObserver()
    }
}