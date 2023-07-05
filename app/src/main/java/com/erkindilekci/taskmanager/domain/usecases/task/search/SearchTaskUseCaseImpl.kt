package com.erkindilekci.taskmanager.domain.usecases.task.search

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchTaskUseCaseImpl @Inject constructor(
    private val repository: TaskRepository
) : SearchTaskUseCase {

    override suspend fun invoke(query: String): Flow<List<Task>> {
        return repository.searchTask(query)
    }
}
