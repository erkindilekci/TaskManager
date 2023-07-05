package com.erkindilekci.taskmanager.domain.usecases.task.get_all

import com.erkindilekci.taskmanager.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface GetAllTaskUseCase {

    suspend operator fun invoke(): Flow<List<Task>>
}
