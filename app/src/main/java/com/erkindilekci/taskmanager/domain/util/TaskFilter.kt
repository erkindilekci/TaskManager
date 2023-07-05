package com.erkindilekci.taskmanager.domain.util

sealed class TaskFilter {
    object All : TaskFilter()
    object Todo : TaskFilter()
    object Progress : TaskFilter()
    object Done : TaskFilter()
}
