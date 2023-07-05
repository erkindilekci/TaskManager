package com.erkindilekci.taskmanager.infrastructure.providers.worker.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.erkindilekci.taskmanager.infrastructure.notification.NotificationUtils
import com.erkindilekci.taskmanager.util.Constants

class TaskWork(ctx: Context, workerParams: WorkerParameters) : Worker(ctx, workerParams) {

    override fun doWork(): Result {
        val taskData = inputData
        val taskTitle = taskData.getString(Constants.WORKER.KEYS.KEY_TITLE)
        val taskDescription = taskData.getString(Constants.WORKER.KEYS.KEY_DESCRIPTION)

        NotificationUtils.showNotification(applicationContext, taskTitle!!, taskDescription!!)

        return Result.success()
    }
}
