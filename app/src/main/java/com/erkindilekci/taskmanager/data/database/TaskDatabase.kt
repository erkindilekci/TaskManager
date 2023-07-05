package com.erkindilekci.taskmanager.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erkindilekci.taskmanager.data.database.entity.TaskEntity

@Database(entities = [TaskEntity::class], exportSchema = false, version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDAO: TaskDao
}
