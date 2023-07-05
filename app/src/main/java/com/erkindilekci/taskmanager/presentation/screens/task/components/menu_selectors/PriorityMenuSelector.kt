package com.erkindilekci.taskmanager.presentation.screens.task.components.menu_selectors

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.screens.home.components.indicator.TaskPriorityIndicator
import com.erkindilekci.taskmanager.presentation.screens.task.components.dropdowns.PriorityDropDownMenu

@Composable
fun PriorityMenuSelector(
    priority: PriorityView,
    onPriorityChange: (PriorityView) -> Unit,
    modifier: Modifier = Modifier
) {
    var menuExpandedState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(TextFieldDefaults.MinHeight / 2)
            .clickable {
                menuExpandedState = true
            }
    ) {
        TaskPriorityIndicator(priority = priority)

        PriorityDropDownMenu(
            onPriorityChange = { prioritySelected ->
                onPriorityChange(prioritySelected)
            },
            menuExpandedState = menuExpandedState,
            menuExpandedStateChange = {
                menuExpandedState = false
            }
        )
    }
}

@Composable
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        var priority by remember { mutableStateOf(PriorityView.NONE) }

        PriorityMenuSelector(
            priority = priority,
            onPriorityChange = { priority = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
