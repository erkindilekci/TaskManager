package com.erkindilekci.taskmanager.domain.usecases.task.edit

import com.erkindilekci.taskmanager.domain.model.Task

interface EditTaskUseCase {

    suspend operator fun invoke(task: Task)
}
