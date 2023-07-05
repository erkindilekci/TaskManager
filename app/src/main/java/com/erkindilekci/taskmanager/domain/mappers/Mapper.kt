package com.erkindilekci.taskmanager.domain.mappers

import com.erkindilekci.taskmanager.data.database.entity.PriorityDto
import com.erkindilekci.taskmanager.data.database.entity.StatusDto
import com.erkindilekci.taskmanager.data.database.entity.TaskEntity
import com.erkindilekci.taskmanager.domain.model.Priority
import com.erkindilekci.taskmanager.domain.model.Status
import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.model.StatusView
import com.erkindilekci.taskmanager.presentation.common.model.TaskView

fun Task.mapToEntity() = TaskEntity(
    id,
    title,
    date,
    time,
    description,
    priority.mapToEntity(),
    status.mapToEntity()
)

fun Priority.mapToEntity() = when (this) {
    Priority.NONE -> PriorityDto.NONE
    Priority.LOW -> PriorityDto.LOW
    Priority.MEDIUM -> PriorityDto.MEDIUM
    Priority.HIGH -> PriorityDto.HIGH
}

fun Status.mapToEntity() = when (this) {
    Status.TODO -> StatusDto.TODO
    Status.PROGRESS -> StatusDto.PROGRESS
    Status.DONE -> StatusDto.DONE
}

fun Task.mapToView() = TaskView(
    id,
    title,
    date,
    time,
    description,
    priority.mapToView(),
    status.mapToView()
)

fun Priority.mapToView() = when (this) {
    Priority.NONE -> PriorityView.NONE
    Priority.LOW -> PriorityView.LOW
    Priority.MEDIUM -> PriorityView.MEDIUM
    Priority.HIGH -> PriorityView.HIGH
}

fun Status.mapToView() = when (this) {
    Status.TODO -> StatusView.TODO
    Status.PROGRESS -> StatusView.PROGRESS
    Status.DONE -> StatusView.DONE
}
