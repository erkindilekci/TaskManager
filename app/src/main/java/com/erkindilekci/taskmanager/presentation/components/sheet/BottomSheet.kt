package com.erkindilekci.taskmanager.presentation.components.sheet

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme

@Composable
@ExperimentalMaterialApi
fun MyBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    screenContent: @Composable () -> Unit,
) {
    ModalBottomSheetLayout(
        modifier = modifier,
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetElevation = 8.dp,
        sheetBackgroundColor = MaterialTheme.colors.primary,
        sheetContent = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider(
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
                    thickness = 8.dp,
                    modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .clip(RoundedCornerShape(percent = 50))
                        .padding(vertical = 8.dp)
                )

                Column(content = sheetContent)
            }
        },
        content = screenContent
    )
}

@Composable
@ExperimentalMaterialApi
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)

        MyBottomSheet(
            sheetState = bottomSheetState,
            sheetContent = {
                Text(text = stringResource(id = R.string.app_name))
            },
            screenContent = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.app_name))
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
