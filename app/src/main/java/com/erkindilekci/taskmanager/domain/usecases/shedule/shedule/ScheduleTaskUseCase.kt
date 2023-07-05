package com.erkindilekci.taskmanager.domain.usecases.shedule.shedule

import com.erkindilekci.taskmanager.domain.model.Task

interface ScheduleTaskUseCase {

    operator fun invoke(task: Task, delayInMillis: Long)
}
