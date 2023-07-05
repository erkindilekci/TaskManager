package com.erkindilekci.taskmanager.domain.usecases.task.filter

import com.erkindilekci.taskmanager.domain.model.Status
import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import com.erkindilekci.taskmanager.domain.util.TaskFilter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilterTaskUseCaseImpl @Inject constructor(
    private val repository: TaskRepository
) : FilterTaskUseCase {

    override suspend fun invoke(filter: TaskFilter): Flow<List<Task>> {
        return when (filter) {
            TaskFilter.All -> {
                repository.getAllTask()
            }

            TaskFilter.Todo -> {
                repository.filterTask(Status.TODO)
            }

            TaskFilter.Progress -> {
                repository.filterTask(Status.PROGRESS)
            }

            TaskFilter.Done -> {
                repository.filterTask(Status.DONE)
            }
        }
    }
}
