package com.erkindilekci.taskmanager.presentation.screens.task.components.dropdowns

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.components.drop_down.MyDropDownMenu

@Composable
fun PriorityDropDownMenu(
    onPriorityChange: (PriorityView) -> Unit,
    menuExpandedState: Boolean,
    menuExpandedStateChange: () -> Unit,
) {

    val priorityItems = listOf(
        stringResource(id = R.string.none),
        stringResource(id = R.string.low),
        stringResource(id = R.string.medium),
        stringResource(id = R.string.high)
    )

    val priorityItemsModels = listOf(
        PriorityView.NONE,
        PriorityView.LOW,
        PriorityView.MEDIUM,
        PriorityView.HIGH,
    )

    MyDropDownMenu(
        items = priorityItems,
        onItemIndexChange = { indexOptionSelected ->
            onPriorityChange(
                priorityItemsModels[indexOptionSelected]
            )
        },
        expandedState = menuExpandedState,
        onExpandedStateChange = menuExpandedStateChange
    )
}
