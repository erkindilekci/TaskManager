package com.erkindilekci.taskmanager.presentation.screens.home.components.filter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.erkindilekci.taskmanager.domain.util.TaskFilter
import com.erkindilekci.taskmanager.presentation.components.widget.WidgetState
import com.erkindilekci.taskmanager.presentation.components.widget.WidgetValue
import com.erkindilekci.taskmanager.presentation.screens.home.HomeViewModel

sealed interface TaskFilterWidgetState : WidgetState {
    var filterQuery: TaskFilter
    fun onFilterQueryChange(query: TaskFilter)
}

class TaskFilterWidgetStateImpl(
    private val homeViewModel: HomeViewModel
) : TaskFilterWidgetState {

    override var filterQuery: TaskFilter by mutableStateOf(TaskFilter.All)
    override val isVisible: Boolean get() = _currentWidgetValueState.value != WidgetValue.Closed

    private val _lastFilterQuery: MutableState<TaskFilter> = mutableStateOf(TaskFilter.All)
    private val _currentWidgetValueState: MutableState<WidgetValue> =
        mutableStateOf(WidgetValue.Closed)

    override fun onFilterQueryChange(query: TaskFilter) {
        filterQuery = query
        if (query != _lastFilterQuery) {
            _lastFilterQuery.value = query
            homeViewModel.onFilterQueryChange(query)
        }
    }

    override fun openWidget() {
        _currentWidgetValueState.value = WidgetValue.Opened
    }

    override fun closeWidget() {
        _currentWidgetValueState.value = WidgetValue.Closed
    }
}


@Composable
fun rememberFilterWidgetState(
    homeViewModel: HomeViewModel = hiltViewModel()
) = remember {
    TaskFilterWidgetStateImpl(homeViewModel = homeViewModel)
}
