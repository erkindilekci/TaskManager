package com.erkindilekci.taskmanager.presentation.screens.task.components.form

import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.model.TaskView

interface TaskFormState {
    val task: TaskView

    fun onTitleChange(title: String)
    fun onTimeChange(hour: Int, minute: Int)
    fun onDateChange(date: String)
    fun onDescriptionChange(description: String)
    fun onPriorityChange(priority: PriorityView)
}
