package com.erkindilekci.taskmanager.domain.usecases.task.get

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import javax.inject.Inject

class GetTaskByIdUseCaseImpl @Inject constructor(
    private val repository: TaskRepository
) : GetTaskByIdUseCase {

    override suspend fun invoke(id: Int): Task? {
        return repository.getTaskById(id)
    }
}
