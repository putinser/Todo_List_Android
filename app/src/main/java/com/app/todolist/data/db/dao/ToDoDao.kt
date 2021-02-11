package com.app.todolist.data.db.dao

import androidx.room.*
import com.app.todolist.data.model.ToDoItem

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todoitem")
    fun getAll(): List<ToDoItem>

    @Query("SELECT id FROM todoitem WHERE rowid = :rowId")
    fun getIdForRowId(rowId: Long): Long

    @Insert
    fun insert(toDoItem: ToDoItem): Long

    @Update
    fun update(toDoItem: ToDoItem)

    @Delete
    fun delete(toDoItem: ToDoItem);

}