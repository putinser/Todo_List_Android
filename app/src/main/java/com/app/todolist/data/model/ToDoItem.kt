package com.app.todolist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoItem(
    val text: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var done: Boolean = false
}