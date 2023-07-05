package com.erkindilekci.taskmanager.presentation.screens.home.components.topbar.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.presentation.common.theme.TaskManagerTheme
import com.erkindilekci.taskmanager.presentation.components.icon.MyIconButton

@Composable
fun SearchTopAppBar(
    modifier: Modifier = Modifier,
    searchWidgetState: SearchWidgetState
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }

    SearchTopAppBarContent(
        query = searchWidgetState.searchQuery,
        onQueryChange = { searchQuery ->
            searchWidgetState.onSearchQueryChange(searchQuery)
        },
        onCloseSearchTopAppBar = {
            searchWidgetState.closeWidget()
        },
        focusRequester = focusRequester,
        modifier = modifier
    )
}

@Composable
private fun SearchTopAppBarContent(
    query: String,
    onQueryChange: (String) -> Unit,
    onCloseSearchTopAppBar: () -> Unit,
    focusRequester: FocusRequester,
    modifier: Modifier,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.primary,
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        TextField(
            value = query,
            onValueChange = { searchQuery ->
                onQueryChange(searchQuery)
            },
            textStyle = TextStyle(fontSize = MaterialTheme.typography.subtitle1.fontSize),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            },
            leadingIcon = {
                MyIconButton(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                )
            },
            trailingIcon = {
                MyIconButton(
                    imageVector = Icons.Filled.Close,
                    contentDescription = null,
                    onClick = {
                        if (query.isNotBlank()) {
                            onQueryChange("")
                        } else {
                            onCloseSearchTopAppBar()
                        }
                    }
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            ),
            modifier = Modifier.focusRequester(focusRequester)
        )
    }
}

@Composable
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun Preview() {
    TaskManagerTheme {
        var query by remember { mutableStateOf("") }

        SearchTopAppBarContent(
            query = query,
            onQueryChange = { searchQuery ->
                query = searchQuery
            },
            onCloseSearchTopAppBar = { },
            focusRequester = FocusRequester(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
