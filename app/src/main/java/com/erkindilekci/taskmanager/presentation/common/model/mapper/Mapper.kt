package com.erkindilekci.taskmanager.presentation.common.model.mapper

import com.erkindilekci.taskmanager.domain.model.Priority
import com.erkindilekci.taskmanager.domain.model.Status
import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.model.StatusView
import com.erkindilekci.taskmanager.presentation.common.model.TaskView

fun TaskView.mapToModel() = Task(
    id,
    title,
    date,
    time,
    description,
    priority.mapToModel(),
    status.mapToModel()
)

fun PriorityView.mapToModel() = when (this) {
    PriorityView.NONE -> Priority.NONE
    PriorityView.LOW -> Priority.LOW
    PriorityView.MEDIUM -> Priority.MEDIUM
    PriorityView.HIGH -> Priority.HIGH
}

fun StatusView.mapToModel() = when (this) {
    StatusView.TODO -> Status.TODO
    StatusView.PROGRESS -> Status.PROGRESS
    StatusView.DONE -> Status.DONE
}
