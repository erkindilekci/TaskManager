package com.erkindilekci.taskmanager.presentation.components.icon

import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
fun MyIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit = {}
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        MyIcon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
private fun Preview() {
    TaskManagerTheme {
        MyIconButton(
            imageVector = Icons.Filled.Search,
            onClick = {}
        )
    }
}
