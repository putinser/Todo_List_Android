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

    override suspend fun addItem(toDoItem: ToDoItem) {
        toDoItem.id = toDoDao.getIdForRowId(toDoDao.insert(toDoItem))
        (toDoListLiveData.value as? ArrayList)?.add(toDoItem)
        withContext(Dispatchers.Main) {
            toDoListLiveData.notifyObserver()
        }
    }

    override suspend fun update(toDoItem: ToDoItem) {
        toDoDao.update(toDoItem)
    }

    override suspend fun remove(toDoItem: ToDoItem, position: Int) {
        toDoDao.delete(toDoItem)
        withContext(Dispatchers.Main) {
            (toDoListLiveData.value as? ArrayList)?.removeAt(position)
            toDoListLiveData.notifyObserver()
        }
    }
}