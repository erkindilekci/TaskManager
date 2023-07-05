package com.erkindilekci.taskmanager.domain.usecases.task.filter

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.util.TaskFilter
import kotlinx.coroutines.flow.Flow

interface FilterTaskUseCase {

    suspend operator fun invoke(filter: TaskFilter): Flow<List<Task>>
}
