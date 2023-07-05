package com.erkindilekci.taskmanager.domain.usecases.task.delete

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import com.erkindilekci.taskmanager.domain.usecases.shedule.cancel.CancelScheduleTaskUseCase
import javax.inject.Inject

class DeleteTaskUseCaseImpl @Inject constructor(
    private val repository: TaskRepository,
    private val cancelScheduleTaskUseCase: CancelScheduleTaskUseCase
) : DeleteTaskUseCase {

    override suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
        cancelScheduleTaskUseCase(task)
    }
}
