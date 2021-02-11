package com.app.todolist.di.app

import android.content.Context
import androidx.room.Room
import com.app.todolist.data.db.AppDatabase
import com.app.todolist.data.db.dao.ToDoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val context: Context) {

    companion object {
        private const val DB_NAME = "tododb"
    }

    private var appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
        .build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }

    @Singleton
    @Provides
    fun providesToDoDao(): ToDoDao {
        return appDatabase.toDoDao()
    }
}