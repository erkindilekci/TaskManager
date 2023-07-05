package com.erkindilekci.taskmanager.domain.providers

interface WorkerProvider<T> {

    fun createWork(data: T, delayInMillis: Long)

    fun cancelWork(data: T)
}
