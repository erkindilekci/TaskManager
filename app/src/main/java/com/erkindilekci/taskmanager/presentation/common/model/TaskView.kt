package com.erkindilekci.taskmanager.presentation.common.model

data class TaskView(
    val id: Int = 0,
    val title: String = "",
    val date: String = "",
    val time: String = "",
    val description: String = "",
    val priority: PriorityView = PriorityView.NONE,
    val status: StatusView = StatusView.TODO
)
