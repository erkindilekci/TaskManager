package com.erkindilekci.taskmanager.domain.usecases.task.save

import com.erkindilekci.taskmanager.domain.model.Task

interface SaveTaskUseCase {

    suspend operator fun invoke(task: Task)
}
