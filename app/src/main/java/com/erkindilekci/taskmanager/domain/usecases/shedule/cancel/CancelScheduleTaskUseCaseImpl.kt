package com.erkindilekci.taskmanager.domain.usecases.shedule.cancel

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.providers.WorkerProvider
import javax.inject.Inject

class CancelScheduleTaskUseCaseImpl @Inject constructor(
    private val workerProvider: WorkerProvider<Task>
) : CancelScheduleTaskUseCase {

    override operator fun invoke(task: Task) {
        workerProvider.cancelWork(task)
    }
}
