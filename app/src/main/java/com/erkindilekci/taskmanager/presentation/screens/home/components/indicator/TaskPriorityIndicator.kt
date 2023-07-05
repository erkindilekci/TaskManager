package com.erkindilekci.taskmanager.presentation.screens.home.components.indicator

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.presentation.common.model.PriorityView
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
fun TaskPriorityIndicator(
    priority: PriorityView,
    modifier: Modifier = Modifier
) {
    val colorPriorityIndicator = if (isSystemInDarkTheme()) {
        priority.colorDark
    } else {
        priority.colorLight
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(TextFieldDefaults.MinHeight / 2)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.01f)
                .background(colorPriorityIndicator)
        )

        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = getPriorityName(priority),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f)
        )
    }
}

private fun getPriorityName(priority: PriorityView) = when (priority) {
    PriorityView.NONE -> "None"
    PriorityView.LOW -> "Low"
    PriorityView.MEDIUM -> "Medium"
    PriorityView.HIGH -> "High"
}

@Composable
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        TaskPriorityIndicator(
            priority = PriorityView.HIGH,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
