package com.erkindilekci.taskmanager.data.repository

import com.erkindilekci.taskmanager.data.database.TaskDao
import com.erkindilekci.taskmanager.data.mappers.mapFromModel
import com.erkindilekci.taskmanager.domain.mappers.mapToEntity
import com.erkindilekci.taskmanager.domain.model.Status
import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val _taskDao: TaskDao
) : TaskRepository {

    override fun getAllTask(): Flow<List<Task>> {
        return _taskDao.getAllTask().map { tasksEntities ->
            tasksEntities.map { taskEntity ->
                taskEntity.mapFromModel()
            }
        }
    }

    override suspend fun getTaskById(id: Int): Task? {
        return _taskDao.getTaskById(id)?.mapFromModel()
    }

    override suspend fun searchTask(query: String): Flow<List<Task>> {
        return _taskDao.searchTask(query).map { tasksEntities ->
            tasksEntities.map { taskEntity ->
                taskEntity.mapFromModel()
            }
        }
    }

    override suspend fun filterTask(filter: Status): Flow<List<Task>> {
        val filterStatusDTO = filter.mapToEntity()
        return _taskDao.filterTask(filterStatusDTO).map { tasksEntities ->
            tasksEntities.map { taskEntity ->
                taskEntity.mapFromModel()
            }
        }
    }

    override suspend fun saveTask(task: Task): Long {
        val taskEntity = task.mapToEntity()
        return _taskDao.saveTask(taskEntity)
    }

    override suspend fun updateTask(task: Task) {
        val taskEntity = task.mapToEntity()
        _taskDao.updateTask(taskEntity)
    }

    override suspend fun deleteTask(task: Task) {
        val taskEntity = task.mapToEntity()
        _taskDao.deleteTask(taskEntity)
    }
}
