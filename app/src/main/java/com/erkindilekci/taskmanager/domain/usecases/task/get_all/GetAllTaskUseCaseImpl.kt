package com.erkindilekci.taskmanager.domain.usecases.task.get_all

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTaskUseCaseImpl @Inject constructor(
    private val repository: TaskRepository
) : GetAllTaskUseCase {

    override suspend fun invoke(): Flow<List<Task>> {
        return repository.getAllTask()
    }
}
