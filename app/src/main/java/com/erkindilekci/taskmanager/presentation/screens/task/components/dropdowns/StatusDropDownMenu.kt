package com.erkindilekci.taskmanager.presentation.screens.task.components.dropdowns

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.model.StatusView
import com.erkindilekci.taskmanager.presentation.components.drop_down.MyDropDownMenu

@Composable
fun StatusDropDownMenu(
    onStatusChange: (StatusView) -> Unit,
    menuExpandedState: Boolean,
    menuExpandedStateChange: () -> Unit,
) {
    val statusItems = listOf(
        stringResource(id = R.string.todo),
        stringResource(id = R.string.progress),
        stringResource(id = R.string.done)
    )

    val statusItemsModels = listOf(
        StatusView.TODO,
        StatusView.PROGRESS,
        StatusView.DONE,
    )

    MyDropDownMenu(
        items = statusItems,
        onItemIndexChange = { indexOptionSelected ->
            onStatusChange(
                statusItemsModels[indexOptionSelected]
            )
        },
        expandedState = menuExpandedState,
        onExpandedStateChange = menuExpandedStateChange
    )
}
