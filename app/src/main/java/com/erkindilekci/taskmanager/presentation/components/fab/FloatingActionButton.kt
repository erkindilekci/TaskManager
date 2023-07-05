package com.erkindilekci.taskmanager.presentation.components.fab

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
fun MyTaskFloatingActionButton(
    imageVector: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = MaterialTheme.colors.onSecondary,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        MyTaskFloatingActionButton(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_task),
            onClick = {}
        )
    }
}
