package com.erkindilekci.taskmanager.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.erkindilekci.taskmanager.data.database.entity.StatusDto
import com.erkindilekci.taskmanager.data.database.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAllTask(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE id = :id")
    suspend fun getTaskById(id: Int): TaskEntity?

    @Query("SELECT * FROM task WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%'")
    fun searchTask(query: String): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE status = :filter")
    fun filterTask(filter: StatusDto): Flow<List<TaskEntity>>

    @Insert
    suspend fun saveTask(taskEntity: TaskEntity): Long

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)
}
