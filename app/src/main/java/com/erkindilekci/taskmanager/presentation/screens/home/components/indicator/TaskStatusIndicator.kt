package com.erkindilekci.taskmanager.presentation.screens.home.components.indicator

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.model.StatusView
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.icon.MyIcon

@Composable
fun TaskStatusIndicator(
    status: StatusView,
    modifier: Modifier = Modifier
) {
    val nameStatus = when (status) {
        StatusView.TODO -> stringResource(id = R.string.todo)
        StatusView.PROGRESS -> stringResource(id = R.string.progress)
        StatusView.DONE -> stringResource(id = R.string.done)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(TextFieldDefaults.MinHeight / 2)
    ) {
        MyIcon(
            imageVector = status.icon
        )

        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = nameStatus,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f)
        )
    }
}

@Composable
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        TaskStatusIndicator(
            status = StatusView.TODO,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
