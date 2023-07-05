package com.erkindilekci.taskmanager.presentation.components.indicator

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.icon.MyIcon

@Composable
fun MyIndicator(
    imageVector: ImageVector,
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(TextFieldDefaults.MinHeight)
            .clickable { onClick() }
    ) {
        IndicatorIconRounded(imageVector = imageVector)

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = title,
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                style = MaterialTheme.typography.caption
            )

            Text(
                text = value,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@Composable
private fun IndicatorIconRounded(imageVector: ImageVector) {
    Box(
        modifier = Modifier
            .padding(start = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colors.primaryVariant.copy(alpha = 0.2f))
    ) {
        MyIcon(
            imageVector = imageVector,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        MyIndicator(
            imageVector = Icons.Filled.Alarm,
            title = "Alarm",
            value = "12:30",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
