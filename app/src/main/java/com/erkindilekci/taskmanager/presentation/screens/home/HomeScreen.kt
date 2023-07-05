package com.erkindilekci.taskmanager.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.erkindilekci.taskmanager.R.*
import com.erkindilekci.taskmanager.presentation.common.model.TaskView
import com.erkindilekci.taskmanager.presentation.common.navigation.Screen
import com.erkindilekci.taskmanager.presentation.components.dialog.MyAlertDialog
import com.erkindilekci.taskmanager.presentation.components.fab.MyTaskFloatingActionButton
import com.erkindilekci.taskmanager.presentation.screens.home.components.card.TaskCard
import com.erkindilekci.taskmanager.presentation.screens.home.components.filter.TaskFilterWidget
import com.erkindilekci.taskmanager.presentation.screens.home.components.filter.rememberFilterWidgetState
import com.erkindilekci.taskmanager.presentation.screens.home.components.sheet.TaskDetailBottomSheet
import com.erkindilekci.taskmanager.presentation.screens.home.components.sheet.rememberTaskDetailBottomSheetState
import com.erkindilekci.taskmanager.presentation.screens.home.components.topbar.home.HomeTopAppBar
import com.erkindilekci.taskmanager.presentation.screens.home.components.topbar.search.SearchTopAppBar
import com.erkindilekci.taskmanager.presentation.screens.home.components.topbar.search.rememberSearchWidgetState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@ExperimentalMaterialApi
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState
    val searchWidgetState = rememberSearchWidgetState()
    val filterWidgetState = rememberFilterWidgetState()
    val taskDetailBottomSheetState = rememberTaskDetailBottomSheetState()

    var dialogDeleteState by remember { mutableStateOf(false) }

    TaskDetailBottomSheet(
        taskDetailBottomSheetState = taskDetailBottomSheetState,
        screenContent = {
            Scaffold(
                topBar = {
                    if (searchWidgetState.isVisible) {
                        SearchTopAppBar(
                            searchWidgetState = searchWidgetState,
                            modifier = Modifier.fillMaxWidth()
                        )
                    } else {
                        HomeTopAppBar(
                            onSearchClicked = {
                                searchWidgetState.openWidget()
                            },
                            onFilterClicked = {
                                if (filterWidgetState.isVisible) {
                                    filterWidgetState.closeWidget()
                                } else {
                                    filterWidgetState.openWidget()
                                }
                            }
                        )
                    }
                },
                floatingActionButton = {
                    MyTaskFloatingActionButton(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(id = string.add_task),
                        onClick = {
                            navHostController.navigate(Screen.AddTaskScreen.route)
                        }
                    )
                },
                content = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TaskFilterWidget(
                            taskFilterWidgetState = filterWidgetState,
                            modifier = Modifier.fillMaxWidth()
                        )

                        TaskListItems(
                            tasks = uiState.tasks,
                            onClickTask = { taskClicked ->
                                taskDetailBottomSheetState.onShowTaskDetailBottomSheet(taskClicked)
                            },
                            onClickEdit = { id ->
                                navHostController.navigate(Screen.EditTaskScreen.route + "?id=$id")
                            },
                            onClickDelete = { task ->
                                dialogDeleteState = true
                                viewModel.onSetTaskDeleted(task)
                            },
                        )
                    }

                    if (dialogDeleteState) {
                        MyAlertDialog(
                            title = stringResource(id = string.title_delete_task_dialog),
                            textDescription = stringResource(id = string.description_delete_task_dialog),
                            onConfirmClick = {
                                viewModel.onDeleteTask()
                                dialogDeleteState = false
                            },
                            onDismissClick = {
                                dialogDeleteState = false
                            }
                        )
                    }
                },
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFF424242) else MaterialTheme.colors.background
            )
        }
    )
}

@Composable
private fun TaskListItems(
    tasks: List<TaskView>,
    onClickTask: (TaskView) -> Unit,
    onClickEdit: (Int) -> Unit,
    onClickDelete: (TaskView) -> Unit
) {
    LazyColumn {
        items(tasks) { task ->
            TaskCard(
                task = task,
                onEditClicked = {
                    onClickEdit(task.id)
                },
                onDeleteClicked = {
                    onClickDelete(task)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { onClickTask(task) },
            )
        }
    }
}
