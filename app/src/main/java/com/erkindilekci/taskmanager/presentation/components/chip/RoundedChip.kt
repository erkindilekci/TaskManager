package com.erkindilekci.taskmanager.presentation.components.chip

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
fun RoundedChip(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val selectedAlpha = if (isSelected) 1f else 0.5f

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onPrimary),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
        modifier = modifier.alpha(selectedAlpha)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreviewSelected() {
    TaskManagerTheme {
        RoundedChip(
            text = "Tasks",
            isSelected = true,
            onClick = {},
            modifier = Modifier
        )
    }
}

@Composable
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreviewNotSelected() {
    TaskManagerTheme {
        RoundedChip(
            text = "Tasks",
            isSelected = false,
            onClick = {},
            modifier = Modifier
        )
    }
}
