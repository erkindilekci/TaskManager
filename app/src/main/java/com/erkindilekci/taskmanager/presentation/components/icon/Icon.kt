package com.erkindilekci.taskmanager.presentation.components.icon

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
fun MyIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String? = null,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = MaterialTheme.colors.onPrimary,
        modifier = modifier
    )
}

@Preview
@Composable
private fun Preview() {
    TaskManagerTheme {
        MyIcon(imageVector = Icons.Filled.Search)
    }
}
