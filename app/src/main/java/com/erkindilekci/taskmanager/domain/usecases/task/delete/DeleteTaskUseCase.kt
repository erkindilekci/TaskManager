package com.erkindilekci.taskmanager.domain.usecases.task.delete

import com.erkindilekci.taskmanager.domain.model.Task

interface DeleteTaskUseCase {

    suspend operator fun invoke(task: Task)
}
