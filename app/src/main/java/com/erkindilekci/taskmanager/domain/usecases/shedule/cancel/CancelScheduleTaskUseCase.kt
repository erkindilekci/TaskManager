package com.erkindilekci.taskmanager.domain.usecases.shedule.cancel

import com.erkindilekci.taskmanager.domain.model.Task

interface CancelScheduleTaskUseCase {

    operator fun invoke(task: Task)
}
