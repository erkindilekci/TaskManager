package com.erkindilekci.taskmanager.presentation.components.top_bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
fun MyTaskTopAppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colors.onPrimary
            )
        },
        navigationIcon = navigationIcon,
        actions = actions
    )
}

@Preview
@Composable
private fun Preview() {
    TaskManagerTheme {
        MyTaskTopAppBar(
            title = stringResource(id = R.string.app_name),
            actions = {}
        )
    }
}
