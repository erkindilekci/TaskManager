package com.erkindilekci.taskmanager.presentation.screens.task.add_task.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.model.TaskView
import com.erkindilekci.taskmanager.presentation.screens.task.add_task.AddTaskViewModel
import com.erkindilekci.taskmanager.presentation.screens.task.components.form.TaskFormState

sealed interface AddTaskFormState : TaskFormState {
    fun onSaveTask()
}

class AddTaskFormStateImpl(
    private val addTaskViewModel: AddTaskViewModel
) : AddTaskFormState {

    override val task: TaskView get() = addTaskViewModel.task.value

    override fun onSaveTask() {
        addTaskViewModel.onSaveTask()
    }

    override fun onTitleChange(title: String) {
        addTaskViewModel.onTitleChange(title)
    }

    override fun onTimeChange(hour: Int, minute: Int) {
        addTaskViewModel.onTimeChange(hour, minute)
    }

    override fun onDateChange(date: String) {
        addTaskViewModel.onDateChange(date)
    }

    override fun onDescriptionChange(description: String) {
        addTaskViewModel.onDescriptionChange(description)
    }

    override fun onPriorityChange(priority: PriorityView) {
        addTaskViewModel.onPriorityChange(priority)
    }
}

@Composable
fun rememberAddTaskFormState(
    addTaskViewModel: AddTaskViewModel
): AddTaskFormState = remember {
    AddTaskFormStateImpl(
        addTaskViewModel = addTaskViewModel
    )
}
