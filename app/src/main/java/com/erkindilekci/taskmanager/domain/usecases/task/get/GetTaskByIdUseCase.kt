package com.erkindilekci.taskmanager.domain.usecases.task.get

import com.erkindilekci.taskmanager.domain.model.Task

interface GetTaskByIdUseCase {

    suspend operator fun invoke(id: Int): Task?
}
