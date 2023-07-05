package com.erkindilekci.taskmanager.presentation.screens.task.components.topbar

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.icon.MyIconButton
import com.erkindilekci.taskmanager.presentation.components.top_bar.MyTaskTopAppBar

@Composable
fun TaskTopAppBar(
    isEditing: Boolean,
    onDeleteClick: () -> Unit,
    onSaveClick: () -> Unit,
    onBackPressed: () -> Unit
) {
    MyTaskTopAppBar(
        title = "",
        navigationIcon = {
            MyIconButton(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.back),
                onClick = onBackPressed
            )
        },
        actions = {
            if (isEditing) {
                MyIconButton(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = stringResource(id = R.string.delete_task),
                    onClick = onDeleteClick
                )
            }

            MyIconButton(
                imageVector = Icons.Filled.Save,
                contentDescription = stringResource(id = R.string.save_task),
                onClick = onSaveClick
            )
        }

    )
}

@Composable
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        TaskTopAppBar(
            isEditing = true,
            onDeleteClick = { },
            onSaveClick = { },
            onBackPressed = { }
        )
    }
}
