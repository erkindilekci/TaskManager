package com.erkindilekci.taskmanager.data.mappers

import com.erkindilekci.taskmanager.data.database.entity.PriorityDto
import com.erkindilekci.taskmanager.data.database.entity.StatusDto
import com.erkindilekci.taskmanager.data.database.entity.TaskEntity
import com.erkindilekci.taskmanager.domain.model.Priority
import com.erkindilekci.taskmanager.domain.model.Status
import com.erkindilekci.taskmanager.domain.model.Task

fun TaskEntity.mapFromModel() = Task(
    id,
    title,
    date,
    time,
    description,
    priority.mapFromModel(),
    status.mapFromModel()
)

fun PriorityDto.mapFromModel() = when (this) {
    PriorityDto.NONE -> Priority.NONE
    PriorityDto.LOW -> Priority.LOW
    PriorityDto.MEDIUM -> Priority.MEDIUM
    PriorityDto.HIGH -> Priority.HIGH
}

fun StatusDto.mapFromModel() = when (this) {
    StatusDto.TODO -> Status.TODO
    StatusDto.PROGRESS -> Status.PROGRESS
    StatusDto.DONE -> Status.DONE
}
