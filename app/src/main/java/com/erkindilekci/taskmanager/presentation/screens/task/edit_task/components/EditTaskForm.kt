package com.erkindilekci.taskmanager.presentation.screens.task.edit_task.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.SoftwareKeyboardController
import com.erkindilekci.taskmanager.presentation.screens.task.components.form.TaskForm

@Composable
@ExperimentalComposeUiApi
fun EditTaskForm(
    modifier: Modifier = Modifier,
    editTaskFormState: EditTaskFormState,
    keyboardController: SoftwareKeyboardController?
) {
    TaskForm(
        taskFormState = editTaskFormState,
        keyboardController = keyboardController,
        modifier = modifier
    )
}
