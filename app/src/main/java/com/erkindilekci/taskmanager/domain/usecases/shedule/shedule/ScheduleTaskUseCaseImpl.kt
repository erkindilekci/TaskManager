package com.erkindilekci.taskmanager.domain.usecases.shedule.shedule

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.providers.WorkerProvider
import javax.inject.Inject

class ScheduleTaskUseCaseImpl @Inject constructor(
    private val workerProvider: WorkerProvider<Task>
) : ScheduleTaskUseCase {

    override operator fun invoke(task: Task, delayInMillis: Long) {
        workerProvider.createWork(task, delayInMillis)
    }
}
