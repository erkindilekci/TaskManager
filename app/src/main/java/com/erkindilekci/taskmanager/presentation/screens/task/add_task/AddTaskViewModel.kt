package com.erkindilekci.taskmanager.presentation.screens.task.add_task

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.taskmanager.domain.usecases.format.date.FormatDateUseCase
import com.erkindilekci.taskmanager.domain.usecases.format.time.FormatTimeUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.save.SaveTaskUseCase
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.model.TaskView
import com.erkindilekci.taskmanager.presentation.common.model.mapper.mapToModel
import com.erkindilekci.taskmanager.presentation.screens.task.add_task.utils.AddTaskScreenEvent
import com.erkindilekci.taskmanager.util.TaskException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val saveTaskUseCase: SaveTaskUseCase,
    private val formatTimeUseCase: FormatTimeUseCase,
    private val formatDateUseCase: FormatDateUseCase,
) : ViewModel() {

    private val _task: MutableState<TaskView> = mutableStateOf(TaskView())
    val task: State<TaskView> get() = _task

    private val _uiEvent: MutableSharedFlow<AddTaskScreenEvent> = MutableSharedFlow()
    val uiEvent: SharedFlow<AddTaskScreenEvent> get() = _uiEvent

    fun onSaveTask() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val task = _task.value.mapToModel()
                saveTaskUseCase(task)
                _uiEvent.emit(AddTaskScreenEvent.SaveTaskSuccess)
            } catch (e: TaskException) {
                _uiEvent.emit(AddTaskScreenEvent.SaveTaskFailed(e.message ?: ""))
            }
        }
    }

    fun onTitleChange(title: String) {
        _task.value = _task.value.copy(title = title)
    }

    fun onTimeChange(hour: Int, minute: Int) {
        val timeFormatted = formatTimeUseCase(hour, minute)
        _task.value = _task.value.copy(time = timeFormatted)
    }

    fun onDateChange(date: String) {
        val dateFormatted = formatDateUseCase(date)
        _task.value = _task.value.copy(date = dateFormatted)
    }

    fun onDescriptionChange(description: String) {
        _task.value = _task.value.copy(description = description)
    }

    fun onPriorityChange(priority: PriorityView) {
        _task.value = _task.value.copy(priority = priority)
    }
}
