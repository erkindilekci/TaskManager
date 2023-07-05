package com.erkindilekci.taskmanager.domain.usecases.task.search

import com.erkindilekci.taskmanager.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface SearchTaskUseCase {

    suspend operator fun invoke(query: String): Flow<List<Task>>
}
