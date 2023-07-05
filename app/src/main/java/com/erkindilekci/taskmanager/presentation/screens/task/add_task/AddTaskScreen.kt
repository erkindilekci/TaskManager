package com.erkindilekci.taskmanager.presentation.screens.task.add_task

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.components.icon.MyIconButton
import com.erkindilekci.taskmanager.presentation.components.top_bar.MyTaskTopAppBar
import com.erkindilekci.taskmanager.presentation.screens.task.add_task.components.AddTaskForm
import com.erkindilekci.taskmanager.presentation.screens.task.add_task.components.rememberAddTaskFormState
import com.erkindilekci.taskmanager.presentation.screens.task.add_task.utils.AddTaskScreenEvent
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@ExperimentalComposeUiApi
fun AddTaskScreen(navController: NavController, viewModel: AddTaskViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val uiState = rememberAddTaskScreenState(addTaskViewModel = viewModel)
    val formState = rememberAddTaskFormState(addTaskViewModel = viewModel)

    LaunchedEffect(key1 = Unit) {
        uiState.uiEvent.collectLatest { uiEvent ->
            when (uiEvent) {
                is AddTaskScreenEvent.SaveTaskSuccess -> {
                    Toast.makeText(
                        context,
                        context.getString(R.string.save_success_task),
                        Toast.LENGTH_SHORT
                    ).show()
                    navController.navigateUp()
                }

                is AddTaskScreenEvent.SaveTaskFailed -> {
                    uiState.showSnackbar(uiEvent.message)
                }
            }
        }
    }

    Scaffold(
        scaffoldState = uiState.scaffoldState,
        topBar = {
            MyTaskTopAppBar(
                title = stringResource(id = R.string.add_task),
                navigationIcon = {
                    MyIconButton(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back),
                        onClick = { navController.navigateUp() }
                    )
                },
                actions = {
                    MyIconButton(
                        imageVector = Icons.Filled.Save,
                        contentDescription = stringResource(id = R.string.add_task),
                        onClick = {
                            keyboardController?.hide()
                            formState.onSaveTask()
                        }
                    )
                }
            )
        },
        content = {
            AddTaskForm(
                addTaskFormState = formState,
                keyboardController = keyboardController,
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}
