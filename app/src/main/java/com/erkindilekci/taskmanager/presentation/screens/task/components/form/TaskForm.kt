package com.erkindilekci.taskmanager.presentation.screens.task.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.screens.task.components.TaskTextField
import com.erkindilekci.taskmanager.presentation.screens.task.components.menu_selectors.PriorityMenuSelector
import com.erkindilekci.taskmanager.presentation.screens.task.components.menu_selectors.StatusMenuSelector
import com.erkindilekci.taskmanager.presentation.screens.task.components.pickers.DatePicker
import com.erkindilekci.taskmanager.presentation.screens.task.components.pickers.TimePicker
import com.erkindilekci.taskmanager.presentation.screens.task.edit_task.components.EditTaskFormState

@Composable
@ExperimentalComposeUiApi
fun TaskForm(
    modifier: Modifier = Modifier,
    taskFormState: TaskFormState,
    keyboardController: SoftwareKeyboardController?
) {
    val (focusRequester) = FocusRequester.createRefs()

    Column(modifier = modifier) {
        TaskTextField(
            value = taskFormState.task.title,
            onValueChange = { taskFormState.onTitleChange(it) },
            textStyle = MaterialTheme.typography.h1,
            placeholderText = stringResource(id = R.string.title),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester.requestFocus() }
            ),
            singleLine = true,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )

        Row {
            PriorityMenuSelector(
                priority = taskFormState.task.priority,
                onPriorityChange = { taskFormState.onPriorityChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 20.dp, top = 10.dp, end = 10.dp)
                    .focusRequester(focusRequester)
            )

            if (taskFormState is EditTaskFormState) {
                StatusMenuSelector(
                    status = taskFormState.task.status,
                    onStatusChange = { taskFormState.onStatusChange(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 20.dp, top = 10.dp, end = 10.dp)
                )
            }
        }

        Row {
            TimePicker(
                value = taskFormState.task.time,
                onValueChange = { hour, minute -> taskFormState.onTimeChange(hour, minute) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            )

            DatePicker(
                value = taskFormState.task.date,
                onValueChange = { date -> taskFormState.onDateChange(date) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            )
        }

        TaskTextField(
            value = taskFormState.task.description,
            onValueChange = { taskFormState.onDescriptionChange(it) },
            textStyle = MaterialTheme.typography.body2,
            placeholderText = stringResource(id = R.string.description),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),
            singleLine = false,
            maxLines = 20,
            modifier = Modifier.fillMaxHeight()
        )
    }
}
