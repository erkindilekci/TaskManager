package com.erkindilekci.taskmanager.presentation.screens.home

import com.erkindilekci.taskmanager.presentation.common.model.TaskView

data class HomeScreenState(
    val tasks: List<TaskView> = emptyList(),
    val taskClickedDelete: TaskView = TaskView()
)
