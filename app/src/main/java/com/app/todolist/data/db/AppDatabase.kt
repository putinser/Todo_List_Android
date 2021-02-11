package com.app.todolist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.todolist.data.model.ToDoItem
import com.app.todolist.data.db.AppDatabase.Companion.DB_VERSION
import com.app.todolist.data.db.dao.ToDoDao

@Database(
    entities = [
        ToDoItem::class
    ],
    version = DB_VERSION
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_VERSION = 1
    }

    abstract fun toDoDao(): ToDoDao
}
