package com.erkindilekci.taskmanager.presentation.screens.home.components.card

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.model.StatusView
import com.erkindilekci.taskmanager.presentation.common.model.TaskView
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.card.MyCard
import com.erkindilekci.taskmanager.presentation.components.drop_down.MyDropDownMenu
import com.erkindilekci.taskmanager.presentation.components.icon.MyIcon
import com.erkindilekci.taskmanager.presentation.components.icon.MyIconButton
import com.erkindilekci.taskmanager.presentation.screens.home.utils.TaskCardAction

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    task: TaskView,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
) {
    var menuExpandedState by remember { mutableStateOf(false) }

    val colorPriority = if (isSystemInDarkTheme()) {
        task.priority.colorDark
    } else {
        task.priority.colorLight
    }

    MyCard(modifier = modifier.wrapContentHeight(Alignment.CenterVertically)) {
        Row {
            PriorityIndicator(
                color = colorPriority
            )

            Column(modifier = Modifier.wrapContentHeight()) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Box(modifier = Modifier.wrapContentSize()) {
                        MyIconButton(
                            imageVector = Icons.Filled.MoreVert,
                            onClick = {
                                menuExpandedState = true
                            },
                            modifier = Modifier.wrapContentSize()
                        )

                        TaskCardDropDownMenu(
                            onActionClicked = { actionSelected ->
                                when (actionSelected) {
                                    TaskCardAction.Edit -> onEditClicked()
                                    TaskCardAction.Delete -> onDeleteClicked()
                                }
                            },
                            menuExpandedState = menuExpandedState,
                            menuExpandedStateChange = { menuExpandedState = false }
                        )
                    }
                }

                Text(
                    text = task.description,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
                    maxLines = 5,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                )

                TaskCardFooter(
                    date = task.date,
                    time = task.time,
                    status = task.status
                )
            }
        }

    }
}

@Composable
private fun PriorityIndicator(color: Color) {
    Divider(
        color = color,
        modifier = Modifier
            .fillMaxHeight()
            .width(2.dp)
    )
}

@Composable
private fun TaskCardDropDownMenu(
    onActionClicked: (TaskCardAction) -> Unit,
    menuExpandedState: Boolean,
    menuExpandedStateChange: () -> Unit,
) {
    val actionOptionsLabels = listOf(
        stringResource(id = R.string.edit),
        stringResource(id = R.string.delete)
    )

    val actionOptions = listOf(
        TaskCardAction.Edit,
        TaskCardAction.Delete
    )

    MyDropDownMenu(
        items = actionOptionsLabels,
        onItemIndexChange = { indexOptionSelected ->
            onActionClicked(actionOptions[indexOptionSelected])
        },
        expandedState = menuExpandedState,
        onExpandedStateChange = menuExpandedStateChange
    )
}

@Composable
private fun TaskCardFooter(
    date: String,
    time: String,
    status: StatusView
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        ScheduleIndicator(
            date = date,
            time = time,
            modifier = Modifier.align(Alignment.CenterStart)
        )

        StatusIndicator(
            status = status,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
private fun ScheduleIndicator(
    date: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        MyIcon(
            imageVector = Icons.Filled.DateRange,
            modifier = Modifier.alpha(0.8f)
        )

        Text(
            text = date,
            style = MaterialTheme.typography.caption
        )

        Spacer(modifier = Modifier.width(8.dp))

        MyIcon(
            imageVector = Icons.Filled.Alarm,
            modifier = Modifier.alpha(0.8f)
        )

        Text(
            text = time,
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
private fun StatusIndicator(
    status: StatusView,
    modifier: Modifier = Modifier
) {
    val statusName = when (status) {
        StatusView.TODO -> stringResource(id = R.string.todo)
        StatusView.PROGRESS -> stringResource(id = R.string.progress)
        StatusView.DONE -> stringResource(id = R.string.done)
    }

    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onPrimary.copy(0.5f),
                shape = RoundedCornerShape(100.dp)
            )
    ) {
        Text(
            text = statusName,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp)
        )
    }
}

@Composable
@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    val task = TaskView(
        1,
        "Study Kotlin",
        "05/07/2023",
        "13:00",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        PriorityView.HIGH,
        StatusView.TODO
    )

    TaskManagerTheme {
        TaskCard(
            task = task,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onEditClicked = {},
            onDeleteClicked = {}
        )
    }
}
