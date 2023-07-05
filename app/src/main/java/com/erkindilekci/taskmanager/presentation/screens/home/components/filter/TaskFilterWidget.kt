package com.erkindilekci.taskmanager.presentation.screens.home.components.filter

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.domain.util.TaskFilter
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.chip.RoundedChip

@Composable
fun TaskFilterWidget(
    modifier: Modifier = Modifier,
    taskFilterWidgetState: TaskFilterWidgetState,
) {
    AnimatedVisibility(
        visible = taskFilterWidgetState.isVisible,
        enter = fadeIn(),
        exit = fadeOut(),
        content = {
            TaskFilterWidgetContent(
                filter = taskFilterWidgetState.filterQuery,
                onFilterChange = { filterQuery ->
                    taskFilterWidgetState.onFilterQueryChange(filterQuery)
                },
                modifier = modifier
            )
        }
    )
}

@Composable
private fun TaskFilterWidgetContent(
    filter: TaskFilter,
    onFilterChange: (TaskFilter) -> Unit,
    modifier: Modifier
) {
    val filterOptions = listOf(
        TaskFilter.All,
        TaskFilter.Todo,
        TaskFilter.Progress,
        TaskFilter.Done
    )

    val filterTextOptions = listOf(
        "Todos",
        stringResource(id = R.string.todo),
        stringResource(id = R.string.progress),
        stringResource(id = R.string.done),
    )

    val filters = filterTextOptions zip filterOptions

    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        items(filters) { filterOption ->
            RoundedChip(
                text = filterOption.first,
                isSelected = filter == filterOption.second,
                onClick = {
                    onFilterChange(filterOption.second)
                },
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Composable
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        var filterSelected by remember { mutableStateOf<TaskFilter>(TaskFilter.All) }

        TaskFilterWidgetContent(
            filter = filterSelected,
            onFilterChange = { filterQuery ->
                filterSelected = filterQuery
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
