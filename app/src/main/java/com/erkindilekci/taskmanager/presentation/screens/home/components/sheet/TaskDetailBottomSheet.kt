package com.erkindilekci.taskmanager.presentation.screens.home.components.sheet

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R.*
import com.erkindilekci.taskmanager.presentation.common.model.TaskView
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.indicator.MyIndicator
import com.erkindilekci.taskmanager.presentation.components.sheet.MyBottomSheet
import com.erkindilekci.taskmanager.presentation.screens.home.components.indicator.TaskPriorityIndicator
import com.erkindilekci.taskmanager.presentation.screens.home.components.indicator.TaskStatusIndicator

@Composable
@ExperimentalMaterialApi
fun TaskDetailBottomSheet(
    taskDetailBottomSheetState: TaskDetailBottomSheetState,
    screenContent: @Composable () -> Unit
) {
    MyBottomSheet(
        sheetState = taskDetailBottomSheetState.sheetState,
        sheetContent = {
            TaskDetailBottomSheetContent(
                taskDetail = taskDetailBottomSheetState.taskDetail,
                modifier = Modifier.fillMaxWidth()
            )
        },
        screenContent = screenContent
    )
}

@Composable
private fun TaskDetailBottomSheetContent(
    modifier: Modifier = Modifier,
    taskDetail: TaskView
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(top = 10.dp, bottom = 20.dp),
    ) {

        val modifierComponents = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp, end = 10.dp)

        Text(
            text = taskDetail.title,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary,
            maxLines = 2,
            modifier = modifierComponents
        )

        Row {
            TaskPriorityIndicator(
                priority = taskDetail.priority,
                modifier = modifierComponents.weight(1f)
            )

            TaskStatusIndicator(
                status = taskDetail.status,
                modifier = modifierComponents.weight(1f)
            )
        }

        MyIndicator(
            imageVector = Icons.Filled.Alarm,
            title = stringResource(id = string.time),
            value = taskDetail.time,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        )

        MyIndicator(
            imageVector = Icons.Filled.DateRange,
            title = stringResource(id = string.date),
            value = taskDetail.date,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        )

        Text(
            text = taskDetail.description,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onPrimary,
            maxLines = 20,
            modifier = modifierComponents,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
@ExperimentalMaterialApi
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        val task = TaskView(
            title = "Title",
            date = "Date",
            time = "Time",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",

            )

        TaskDetailBottomSheetContent(
            taskDetail = task,
            modifier = Modifier.fillMaxWidth()
        )
    }
}